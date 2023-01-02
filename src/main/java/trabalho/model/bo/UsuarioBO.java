//package trabalho.model.bo;
//
//import br.edu.ifg.luziania.tiii.model.dao.impl.PessoaDAO;
//import br.edu.ifg.luziania.tiii.model.dto.UsuarioDTO;
//import br.edu.ifg.luziania.tiii.model.dto.PessoaFormDTO;
//import br.edu.ifg.luziania.tiii.model.entity.Pessoa;
//
//import javax.enterprise.context.Dependent;
//import javax.inject.Inject;
//
//@Dependent
//public class PessoaBO {
//
//    @Inject
//    PessoaDAO pessoaDAO;
//
//    public PessoaFormDTO getFormData() {
//        PessoaFormDTO dto = new PessoaFormDTO();
//        dto.getSexos().add("Masculino");
//        dto.getSexos().add("Feminino");
//        return dto;
//    }
//
//    public Boolean save(UsuarioDTO dto) {
//        pessoaDAO.insert(new Pessoa(dto));
//        pessoaDAO.save(dto);
//
//
//        boolean a = true;
//
//        if(a){
//
//        }
//
//
//        return true;
//    }
//}
