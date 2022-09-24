import * as PIXI from "https://cdn.skypack.dev/pixi.js";
import { KawaseBlurFilter } from "https://cdn.skypack.dev/@pixi/filter-kawase-blur";
import SimplexNoise from "https://cdn.skypack.dev/simplex-noise@3.0.0";
import hsl from "https://cdn.skypack.dev/hsl-to-hex";
import debounce from "https://cdn.skypack.dev/debounce";

// retornar um número aleatório dentro de um intervalo
function random(min, max) {
    return Math.random() * (max - min) + min;
}

// mapear um número de 1 intervalo para outro
function map(n, start1, end1, start2, end2) {
    return ((n - start1) / (end1 - start1)) * (end2 - start2) + start2;
}

// Criar uma nova instância de ruído simplex
const simplex = new SimplexNoise();

// Classe ColorPalette
class ColorPalette {
    constructor() {
        this.setColors();
        this.setCustomProperties();
    }

    setColors() {
        // escolha um tom aleatório em algum lugar entre 220 e 360
        this.hue = ~~random(220, 360);
        this.complimentaryHue1 = this.hue + 30;
        this.complimentaryHue2 = this.hue + 60;
        // definir uma saturação fixa e leveza
        this.saturation = 95;
        this.lightness = 50;

        // definir uma cor base
        this.baseColor = hsl(this.hue, this.saturation, this.lightness);
        // definir uma cor complementar, a 30 graus de distância da base
        this.complimentaryColor1 = hsl(
            this.complimentaryHue1,
            this.saturation,
            this.lightness
        );
        // definir uma segunda cor complementar, a 60 graus da base
        this.complimentaryColor2 = hsl(
            this.complimentaryHue2,
            this.saturation,
            this.lightness
        );

        // armazene as opções de cores em uma matriz para que uma aleatória possa ser escolhida mais tarde
        this.colorChoices = [
            this.baseColor,
            this.complimentaryColor1,
            this.complimentaryColor2
        ];
    }

    randomColor() {
        //escolha uma cor aleatória
        return this.colorChoices[~~random(0, this.colorChoices.length)].replace(
            "#",
            "0x"
        );
    }

    setCustomProperties() {
        // defina propriedades personalizadas de CSS para que as cores definidas aqui possam ser usadas em toda a interface do usuário
        document.documentElement.style.setProperty("--hue", this.hue);
        document.documentElement.style.setProperty(
            "--hue-complimentary1",
            this.complimentaryHue1
        );
        document.documentElement.style.setProperty(
            "--hue-complimentary2",
            this.complimentaryHue2
        );
    }
}

// Orb class
class Orb {
    // Pixi usa cores hexadecimais como literais hexadecimais (0x em vez de uma string com '#')
    constructor(fill = 0x000000) {
        // limites = a área que um orbe tem "permissão" para se mover dentro
        this.bounds = this.setBounds();
        // inicialize os valores { x, y } do orb para um ponto aleatório dentro de seus limites
        this.x = random(this.bounds["x"].min, this.bounds["x"].max);
        this.y = random(this.bounds["y"].min, this.bounds["y"].max);

        // quão grande é o orbe vs seu raio original (isso irá modular ao longo do tempo)
        this.scale = 1;

        //qual a cor do orbe?
        this.fill = fill;

        // o raio original do orbe, definido em relação à altura da janela
        this.radius = random(window.innerHeight / 6, window.innerHeight / 3);

        //pontos de partida em "tempo" para os valores aleatórios de ruído/auto-similares
        this.xOff = random(0, 1000);
        this.yOff = random(0, 1000);
        // a rapidez com que os valores aleatórios de ruído/auto-similares percorrem o tempo
        this.inc = 0.002;

        // PIXI.Graphics é usado para desenhar primitivas 2d (neste caso um círculo) para a tela
        this.graphics = new PIXI.Graphics();
        this.graphics.alpha = 0.825;

        // 250ms após o último evento de redimensionamento da janela, recalcular as posições dos orbes.
        window.addEventListener(
            "resize",
            debounce(() => {
                this.bounds = this.setBounds();
            }, 250)
        );
    }

    setBounds() {
        // quão longe da origem { x, y } cada orbe pode se mover
        const maxDist =
            window.innerWidth < 1000 ? window.innerWidth / 3 : window.innerWidth / 5;
        // a origem { x, y } para cada orbe (no canto inferior direito da tela)
        const originX = window.innerWidth / 1.25;
        const originY =
            window.innerWidth < 1000
                ? window.innerHeight
                : window.innerHeight / 1.375;

        // permitir que cada orbe se mova x distâncias de sua origem x / y
        return {
            x: {
                min: originX - maxDist,
                max: originX + maxDist
            },
            y: {
                min: originY - maxDist,
                max: originY + maxDist
            }
        };
    }

    update() {
        // valores "psuedo-aleatórios" ou de ruído auto-similares em um determinado ponto no "tempo"
        const xNoise = simplex.noise2D(this.xOff, this.xOff);
        const yNoise = simplex.noise2D(this.yOff, this.yOff);
        const scaleNoise = simplex.noise2D(this.xOff, this.yOff);

        // mapear os valores xNoise/yNoise (entre -1 e 1) para um ponto dentro dos limites do orbe
        this.x = map(xNoise, -1, 1, this.bounds["x"].min, this.bounds["x"].max);
        this.y = map(yNoise, -1, 1, this.bounds["y"].min, this.bounds["y"].max);
        // mapear scaleNoise (entre -1 e 1) para um valor de escala em algum lugar entre metade do tamanho original do orbe e 100% do tamanho original
        this.scale = map(scaleNoise, -1, 1, 0.5, 1);

        //passo através do "tempo"
        this.xOff += this.inc;
        this.yOff += this.inc;
    }

    render() {
        // atualizar os valores de posição e escala do PIXI.Graphics
        this.graphics.x = this.x;
        this.graphics.y = this.y;
        this.graphics.scale.set(this.scale);

        //limpar qualquer coisa atualmente desenhada para gráficos
        this.graphics.clear();

        // diga aos gráficos para preencher quaisquer formas desenhadas depois disso com a cor de preenchimento do orbe
        this.graphics.beginFill(this.fill);
        // desenhe um círculo em { 0, 0 } com seu tamanho definido por this.radius
        this.graphics.drawCircle(0, 0, this.radius);
        // deixe os gráficos saberem que não vamos preencher mais formas
        this.graphics.endFill();
    }
}

// Criar aplicativo PixiJS
const app = new PIXI.Application({
    // renderizar para <canvas class="orb-canvas"></canvas>
    view: document.querySelector(".orb-canvas"),
    //ajuste automático do tamanho para caber na janela atual
    resizeTo: window,
    //fundo transparente, estaremos criando um fundo gradiente mais tarde usando CSS
    transparent: true
});

// Criar paleta de cores
const colorPalette = new ColorPalette();

app.stage.filters = [new KawaseBlurFilter(30, 10, true)];

// Criar orbes
const orbs = [];

for (let i = 0; i < 10; i++) {
    const orb = new Orb(colorPalette.randomColor());

    app.stage.addChild(orb.graphics);

    orbs.push(orb);
}

// Animação
if (!window.matchMedia("(prefers-reduced-motion: reduce)").matches) {
    app.ticker.add(() => {
        orbs.forEach((orb) => {
            orb.update();
            orb.render();
        });
    });
} else {
    orbs.forEach((orb) => {
        orb.update();
        orb.render();
    });
}

document
    .querySelector(".overlay__btn--colors")
    .addEventListener("click", () => {
        colorPalette.setColors();
        colorPalette.setCustomProperties();

        orbs.forEach((orb) => {
            orb.fill = colorPalette.randomColor();
        });
    });