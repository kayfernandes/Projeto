//package trabalho.controller;
//
//import trabalho.model.bo.UsuarioBO;
//import trabalho.model.dto.UsuarioDTO;
//import io.quarkus.qute.CheckedTemplate;
//import io.quarkus.qute.TemplateInstance;
//
//import javax.inject.Inject;
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//@Path("Usuario")
//public class CadastroUsuarioController {
//
//    @Inject
//    UsuarioBO bo;
//
//    @CheckedTemplate
//    public static class Templates {
//        public static native TemplateInstance cadastro();
//    }
//
//    @GET
//    @Path("cadastro")
//    @Produces(MediaType.TEXT_HTML)
//    public TemplateInstance getCadastroHTML(){
//        return Templates.cadastro();
//    }
//
//    @GET
//    @Path("cadastro/form")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.TEXT_PLAIN)
//    public Response getName(){
//        return Response.ok(bo.getClass()).build();
//    }
//
//    @POST
//    @Path("cadastro/save")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response save(UsuarioDTO dto){
//        return Response.ok(bo.save(dto)).build();
//    }
//
//}
//
