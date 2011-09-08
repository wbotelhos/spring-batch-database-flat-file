package br.com.wbotelhos.spring.batch.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import br.com.wbotelhos.spring.batch.model.Pagamento;

@Component("pagamentoRowMapper")
public class PagamentoRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pagamento pagamento = new Pagamento();

		pagamento.setDepositante(rs.getString("depositante"));
		pagamento.setCodigo(rs.getInt("codigo"));
		pagamento.setTipo(rs.getString("tipo"));
		pagamento.setData(rs.getDate("data"));
		pagamento.setValor(rs.getDouble("valor"));
		pagamento.setComentario(rs.getString("comentario"));

		return pagamento;
	}

}