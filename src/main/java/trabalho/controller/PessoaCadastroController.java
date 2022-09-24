package trabalho.controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import trabalho.model.bo.PessoaBO;
import trabalho.model.dto.PessoaDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("pessoa")
public class PessoaCadastroController {

    @Inject
    PessoaBO bo;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance cadastro();
    }

    @GET
    @Path("cadastro")
    public TemplateInstance getHTMLFile(){
        return Templates.cadastro();
    }


    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(PessoaDTO dto){
        bo.save(dto);
        return Response.ok().build();
    }

}
