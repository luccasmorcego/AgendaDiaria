import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Agenda {
    private JTextField inputCompromisso;
    private JPanel compromissos;
    private JSpinner spinnerData;
    private JButton btnAdd;
    private JTable tabela;
    private JButton btnDel;
    private JSpinner spinnerHoras;

    public static void main(String[] args){

        JFrame tela = new JFrame("Agenda Diaria");
        tela.setContentPane(new Agenda().compromissos);
        tela.setSize(500,500);
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tela.setVisible(true);

    }

    public Agenda(){

        SpinnerDateModel dataModel = new SpinnerDateModel();
        spinnerData.setModel(dataModel);
        JSpinner.DateEditor formatoDDMMAA = new JSpinner.DateEditor(spinnerData, "dd/MM/yyyy");
        spinnerData.setEditor(formatoDDMMAA);

        SpinnerDateModel horaModel = new SpinnerDateModel();
        spinnerHoras.setModel(horaModel);
        JSpinner.DateEditor formatoHora = new JSpinner.DateEditor(spinnerHoras, "HH:mm");
        spinnerHoras.setEditor(formatoHora);

        String[] colunas = {"Descrição", "Data"};
        DefaultTableModel tabelaModel = new DefaultTableModel(colunas, 0);
        tabela.setModel(tabelaModel);
        Object[] novaLinha = {"DESCRIÇÃO", "DATA"};
        tabelaModel.addRow(novaLinha);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Date dataEscolhida = (Date) spinnerData.getValue();
                Date horaEscolhida = (Date) spinnerHoras.getValue();
                dataEscolhida.setHours(horaEscolhida.getHours());
                dataEscolhida.setMinutes(horaEscolhida.getMinutes());

                Object[] novaLinha = {inputCompromisso.getText(), dataEscolhida, horaEscolhida};
                tabelaModel.addRow(novaLinha);

            }
        });

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tabelaModel.removeRow(tabela.getSelectedRow());

            }
        });

    }
}