package trabalho.controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class FullSneakersController{

    @CheckedTemplate
    public static class templates {
        public static native TemplateInstance FullSneakers();

    }

    @GET
    @Path("FullSneakers")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getFullSneakersHTML() {

        return FullSneakersController.templates.FullSneakers();
    }


}
