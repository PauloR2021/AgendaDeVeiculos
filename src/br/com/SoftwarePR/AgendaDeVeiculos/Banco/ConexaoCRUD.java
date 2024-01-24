/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.SoftwarePR.AgendaDeVeiculos.Banco;

import br.com.SoftwarePR.AgendaDeVeiculos.Construtor.ConstrutorAgenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo Ricardo
 */
public class ConexaoCRUD {

    private Connection conexao;

    public Connection getConnection() {

        try {
            return DriverManager.getConnection("jdbc:ucanaccess://AgendaVeiculo.accdb");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, "Erro no Banco de Dados" + e);
        }
        return null;

    }
    
    //Metodo para fazer uma Consulta em Todo o Banco de Dados
    public List<ConstrutorAgenda> Consutar() {

        List<ConstrutorAgenda> lista = new ArrayList<>();

        this.conexao = new ConexaoCRUD().getConnection();

        String sql = "Select * from Tb_agenda";

        try {
            PreparedStatement consultarInformacao = conexao.prepareStatement(sql);

            ResultSet resultado = consultarInformacao.executeQuery();

            while (resultado.next()) {

                ConstrutorAgenda linha = new ConstrutorAgenda();

                linha.setVeiculo(resultado.getString("veiculo"));
                linha.setData(resultado.getString("data_saida"));
                linha.setHora(resultado.getString("hora_saida"));
                linha.setDatachegada(resultado.getString("data_chegada"));
                linha.setHorachegada(resultado.getString("hora_chegada"));
                linha.setColaborador(resultado.getString("colaborador"));
                linha.setObservacao(resultado.getString("observacao"));

                lista.add(linha);
            }

            return lista;

        } catch (SQLException e) {
            // TODO Auto-generated catch block

        }
        return null;

    }
    
    //Metodo para fazer uma Consulta em Todo o Banco de Dados com Filtro de Veiculos e Datas
    public List<ConstrutorAgenda> ConsutarComFiltro(String veiculo, String data) {

        List<ConstrutorAgenda> lista = new ArrayList<>();

        this.conexao = new ConexaoCRUD().getConnection();

        String sql = "Select * from Tb_agenda where veiculo like ? AND data_saida like ?";

        try {

            PreparedStatement consultarInformacao = conexao.prepareStatement(sql);

            consultarInformacao.setString(1, veiculo);
            consultarInformacao.setString(2, data);

            ResultSet resultado = consultarInformacao.executeQuery();

            while (resultado.next()) {

                ConstrutorAgenda linha = new ConstrutorAgenda();

                linha.setVeiculo(resultado.getString("veiculo"));
                linha.setData(resultado.getString("data_saida"));
                linha.setHora(resultado.getString("hora_saida"));
                linha.setDatachegada(resultado.getString("data_chegada"));
                linha.setHorachegada(resultado.getString("hora_chegada"));
                linha.setColaborador(resultado.getString("colaborador"));
                linha.setObservacao(resultado.getString("observacao"));

                lista.add(linha);
            }

            return lista;

        } catch (SQLException e) {
            // TODO Auto-generated catch block

        }
        return null;

    }
    
    //Metodo para fazer uma Consulta em Todo o Banco de Dados com Filtro de Veiculos 
    public List<ConstrutorAgenda> ConsutarComFiltroVeiculos(String veiculo) {

        List<ConstrutorAgenda> lista = new ArrayList<>();

        this.conexao = new ConexaoCRUD().getConnection();

        String sql = "Select * from Tb_agenda where veiculo like ?";

        try {

            PreparedStatement consultarInformacao = conexao.prepareStatement(sql);

            consultarInformacao.setString(1, veiculo);
            

            ResultSet resultado = consultarInformacao.executeQuery();

            while (resultado.next()) {

                ConstrutorAgenda linha = new ConstrutorAgenda();

                linha.setVeiculo(resultado.getString("veiculo"));
                linha.setData(resultado.getString("data_saida"));
                linha.setHora(resultado.getString("hora_saida"));
                linha.setDatachegada(resultado.getString("data_chegada"));
                linha.setHorachegada(resultado.getString("hora_chegada"));
                linha.setColaborador(resultado.getString("colaborador"));
                linha.setObservacao(resultado.getString("observacao"));

                lista.add(linha);
            }

            return lista;

        } catch (SQLException e) {
            // TODO Auto-generated catch block

        }
        return null;

    }
    
    //Metodo para Adicionar a Agenda no Banco de Dados
    public void AdicionarAgenda(ConstrutorAgenda objeto) {

        String sql = "INSERT INTO Tb_agenda(veiculo,data_saida,hora_saida,data_chegada,hora_chegada,colaborador,observacao)"
                + "values(?,?,?,?,?,?,?)";

        try {

            this.conexao = new ConexaoCRUD().getConnection();

            PreparedStatement gravardados = conexao.prepareStatement(sql);

            gravardados.setString(1, objeto.getVeiculo());
            gravardados.setString(2, objeto.getData());
            gravardados.setString(3, objeto.getHora());
            gravardados.setString(4, objeto.getDatachegada());
            gravardados.setString(5, objeto.getHorachegada());
            gravardados.setString(6, objeto.getColaborador());
            gravardados.setString(7, objeto.getObservacao());

            gravardados.execute();

            JOptionPane.showMessageDialog(null, "Agenda Salva com Sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
