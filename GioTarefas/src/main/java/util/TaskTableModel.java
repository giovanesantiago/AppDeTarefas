
package util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;


public class TaskTableModel extends AbstractTableModel{
    
    // Atributos
    String[] columns = {"Nome", "Descrição", "Prazo", 
        "Tarefa Concluida", "Editar", "Excluir"};
    List<Task> tasks = new ArrayList();
    private int conlumnIndex;
    
    // Quantas linhas a tabela vai ter
    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(conlumnIndex){
            case 1:
                return tasks.get(rowIndex).getName();
            case 2:
                return tasks.get(rowIndex).getDescription();
            case 3:
                return tasks.get(rowIndex).getDeadline();
            case 4:
                return tasks.get(rowIndex).isIsCompleted();
            case 5:
                return "";
            case 6:
                return "";    
            default:
                return "Dados não encontrado";
        }
        
    }
    
}
