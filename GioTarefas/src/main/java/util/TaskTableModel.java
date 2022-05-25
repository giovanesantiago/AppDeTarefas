
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;


public class TaskTableModel extends AbstractTableModel{
    
    // Atributos
    private final String[] columns = {"Nome", "Descrição", "Prazo",
        "Tarefa Concluida", "Editar", "Excluir"};
    private List<Task> tasks = new ArrayList();
    private int conlumnIndex;
    
    // Quantas linhas a tabela vai ter
    @Override
    public int getRowCount() {
        //System.out.println(tasks.size());
        return tasks.size();
        
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return columns[columnIndex];
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // System.out.print(columnIndex);
        //System.out.print(rowIndex);
        switch(columnIndex){
            case 0:
                return tasks.get(rowIndex).getName();
            case 1:
                return tasks.get(rowIndex).getDescription();
            case 2:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(tasks.get(rowIndex).getDeadline());
            case 3:
                return tasks.get(rowIndex).isIsCompleted();
            case 4:
                return "";
            case 5:
                return "";    
            default:
                return "Dados não encontrado";
        }
        
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    
    
    
    
    
}
