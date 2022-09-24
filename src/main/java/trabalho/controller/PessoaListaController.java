package trabalho.controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("pessoa")
public class PessoaListaController {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance lista();
    }

    @GET
    @Path("lista")
    public TemplateInstance getHTMLFile(){
        return Templates.lista();
    }
}
