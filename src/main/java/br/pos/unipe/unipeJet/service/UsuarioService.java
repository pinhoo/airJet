package br.pos.unipe.unipeJet.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pos.unipe.unipeJet.model.Usuario;
import br.pos.unipe.unipeJet.repository.Usuarios;

@Service
public class UsuarioService {

	@Autowired
	private Usuarios usuarios;
	
	public void salvar(Usuario usuario){
		//Gerando o cartão de milhas
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyddMMHHmm");
		Date data = new Date();
		String convertDate = dateFormat.format(data);
		usuario.setCartaoMilhas(convertDate);
		//Formatando a data
		/*SimpleDateFormat formatData = new SimpleDateFormat("dd-MM-yyyy");
		String formatarData = formatData.format(usuario.getDataNascimento());
		try {
			Date dataFinal = formatData.parse(formatarData);
			usuario.setDataNascimento(dataFinal);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		this.usuarios.save(usuario);
	}
	
	public void find(Long id){
		this.usuarios.findOne(id);
	}
}
