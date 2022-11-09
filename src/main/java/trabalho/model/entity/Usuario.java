//package trabalho.model.entity;
//
//
//import org.jboss.resteasy.core.NoMessageBodyWriterFoundFailure;
//import trabalho.model.dto.UsuarioDTO;
//
////import javax.persistence.Entity;
////import javax.persistence.GeneratedValue;
////import javax.persistence.Id;
////import javax.persistence.SequenceGenerator;
//
////@Entity
//public class Usuario {
//
////@Id
////@SequenceGenerator(name = "pessoa_id", sequenceName = "pessoa_id_seq", allocationSize = 1, initialValue = 1)
////@GeneratedValue(generator = "pessoa_id")
//    private String Nome;
//    private String Email;
//    private String Senha;
//
//    public Usuario(UsuarioDTO dto){
//        this.Nome = dto.getNome();
//        this.Email = dto.getEmail();
//        this.Senha= dto.getSenha();
//
//    }
//
//
//    public Usuario(String Nome, String Email) {
//        this.Nome = Nome;
//        this.Email = Email;
//    }
//
//
//    public String getNome() {
//        return Nome;}
//
//    public void setNome(String Nome) {
//        this.Nome = Nome;
//    }
//
//    public String getEmail() {
//        return Email;
//    }
//
//    public void setEmail(String Email) {
//        this.Email = Email;
//    }
//
//    public String getSenha() {
//        return Senha;
//    }
//
//    public void setSenha(String Senha) {
//        this.Senha = Senha;
//    }
//}
