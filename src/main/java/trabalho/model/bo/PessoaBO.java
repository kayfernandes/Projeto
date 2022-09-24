package trabalho.model.bo;


@Dependent
public class PessoaBO {
    @Inject
    PessoaDAO pessoaDAO;

    public PessoaFormDTO getFormData() {
        PessoaFormDTO dto = new PessoaFormDTO();
        dto.getEmail().add("Email");
        dto.getNome().add("Nome");
        dto.getSenha().add("Senha");

        return dto;
    }

    public Boolean save(PessoaDTO dto) {
        pessoaDAO.insert(new Pessoa(dto));
        return true;
    }
}
