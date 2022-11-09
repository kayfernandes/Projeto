//package trabalho.model.bo;
//
//import trabalho.model.dao.impl.UsuarioDAO;
//import trabalho.model.dto.UsuarioDTO;
//import trabalho.model.entity.Usuario;
//import javax.enterprise.context.Dependent;
//import javax.inject.Inject;
//import java.util.List;
//
//@Dependent
//public class UsuarioBO {
//
//    @Inject
//    UsuarioDAO dao;
//
//    private boolean validador(UsuarioDTO dto){
//        return !(dto.getNome().isBlank() || dto.getEmail().isBlank() || dto.getSenha().isBlank());
//    }
//
//
//    public Object save(UsuarioDTO dto) {
//        if (validador(dto)){
//            dao.insert(new Usuario(dto));
//        }
//        List<Usuario> usuarios = dao.getAll();
//        usuarios.size();
//        return null;
//    }
//
////        public UsuarioFormDTO getFormData() {
////            UsuarioFormDTO dto = new UsuarioFormDTO();
////            dto.getSexos().add("Masculino");
////           dto.getSexos().add("Feminino");
////            return dto;
////        }
//
//}
//
