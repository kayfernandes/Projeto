//package trabalho.controller;
//
//import io.quarkus.qute.CheckedTemplate;
//import io.quarkus.qute.TemplateInstance;
//import trabalho.model.bo.PessoaBO;
//import trabalho.model.dto.PessoaDTO;
//
//import javax.inject.Inject;
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//@Produces()
//@Path("pessoa")
//public class PessoaCadastroController {
//
//    @Inject
//    PessoaBO bo;
//
//    @CheckedTemplate
//    public static class templates {
//        public static native TemplateInstance Cadastro();
//    }
//
//    @GET
//    @Path("cadastro")
//    public TemplateInstance getHTMLFile(){
//        return templates.Cadastro();
//    }
//
//
//    @POST
//    @Path("save")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response save(PessoaDTO dto){
//        bo.save(dto);
//        return Response.ok().build();
//    }
//
//}
