package trabalho.controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class LoginController {

    @CheckedTemplate
    public static class templates {
        public static native TemplateInstance login();

    }

    @GET
    @Path("login")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getLoginHTML() {
        return templates.login();
    }

    @GET
    @Path("autenticar/{usuario}/{senha}")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance autenticar(@PathParam("usuario") String usuario, @PathParam("senha") String senha) {
        return FullSneakersController.templates.FullSneakers();
    }


}
