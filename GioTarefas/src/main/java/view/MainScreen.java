/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ListController;
import controller.TaskController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import model.Lista;
import util.TaskTableModel;

/**
 *
 * @author cliente
 */
public class MainScreen extends javax.swing.JFrame {

    // Criando controladores
    ListController listController;
    TaskController taskController;
    
    // Modelo do componente grafico da Lista
    DefaultListModel listModel;
    TaskTableModel taskModel;
    
    public MainScreen() {
        initComponents();
        
        // Iniciando decora��o da tabela
        decorateTableTask();
        
        // Inciando Controladores
        initDataController();
        
        // Iniciando Modelos de Lista
        initComponetsModel();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelEmptyList = new javax.swing.JPanel();
        jLabelEmptyListIcon = new javax.swing.JLabel();
        jLabelEmptyListTitle = new javax.swing.JLabel();
        jLabelEmptyListSubTitle = new javax.swing.JLabel();
        jPanelToolbar = new javax.swing.JPanel();
        jLabelToolbarTitle = new javax.swing.JLabel();
        jLabelToolbarSubTitle = new javax.swing.JLabel();
        jPanelLists = new javax.swing.JPanel();
        jLabelListsTitle = new javax.swing.JLabel();
        jLabelListsAdd = new javax.swing.JLabel();
        jPanelTasks = new javax.swing.JPanel();
        jLabelTasksTitle = new javax.swing.JLabel();
        jLabelTasksAdd = new javax.swing.JLabel();
        jPanelListsList = new javax.swing.JPanel();
        jScrollPaneLists = new javax.swing.JScrollPane();
        jListLists = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPaneTasks = new javax.swing.JScrollPane();
        jTableTasks = new javax.swing.JTable();

        jPanelEmptyList.setBackground(new java.awt.Color(255, 255, 255));

        jLabelEmptyListIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyListIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lists.png"))); // NOI18N
        jLabelEmptyListIcon.setToolTipText("");
        jLabelEmptyListIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelEmptyListTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmptyListTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelEmptyListTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyListTitle.setText("Nenhuma Tarefa por aqui ;D");

        jLabelEmptyListSubTitle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelEmptyListSubTitle.setForeground(new java.awt.Color(153, 153, 153));
        jLabelEmptyListSubTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyListSubTitle.setText("Clique no bot�o \"+\" para adicionar uma nova tarefa");

        javax.swing.GroupLayout jPanelEmptyListLayout = new javax.swing.GroupLayout(jPanelEmptyList);
        jPanelEmptyList.setLayout(jPanelEmptyListLayout);
        jPanelEmptyListLayout.setHorizontalGroup(
            jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmptyListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEmptyListIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEmptyListTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEmptyListSubTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelEmptyListLayout.setVerticalGroup(
            jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmptyListLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabelEmptyListIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEmptyListTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEmptyListSubTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setMinimumSize(new java.awt.Dimension(800, 600));

        jPanelToolbar.setBackground(new java.awt.Color(0, 153, 102));
        jPanelToolbar.setForeground(new java.awt.Color(0, 0, 0));

        jLabelToolbarTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelToolbarTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelToolbarTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick.png"))); // NOI18N
        jLabelToolbarTitle.setText(" Gio Tarefas");

        jLabelToolbarSubTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelToolbarSubTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelToolbarSubTitle.setText("Anote tudo n�o esque�a de nada");

        javax.swing.GroupLayout jPanelToolbarLayout = new javax.swing.GroupLayout(jPanelToolbar);
        jPanelToolbar.setLayout(jPanelToolbarLayout);
        jPanelToolbarLayout.setHorizontalGroup(
            jPanelToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolbarLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelToolbarSubTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelToolbarTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelToolbarLayout.setVerticalGroup(
            jPanelToolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolbarLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabelToolbarTitle)
                .addGap(18, 18, 18)
                .addComponent(jLabelToolbarSubTitle)
                .addGap(16, 16, 16))
        );

        jPanelLists.setBackground(new java.awt.Color(255, 255, 255));
        jPanelLists.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelListsTitle.setBackground(new java.awt.Color(255, 255, 255));
        jLabelListsTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelListsTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelListsTitle.setText(" Listas");

        jLabelListsAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelListsAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jLabelListsAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelListsAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelListsLayout = new javax.swing.GroupLayout(jPanelLists);
        jPanelLists.setLayout(jPanelListsLayout);
        jPanelListsLayout.setHorizontalGroup(
            jPanelListsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelListsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelListsAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelListsLayout.setVerticalGroup(
            jPanelListsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelListsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelListsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelListsAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelTasks.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTasks.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTasksTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTasksTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelTasksTitle.setText(" Tarefas");

        jLabelTasksAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jLabelTasksAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTasksAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelTasksLayout = new javax.swing.GroupLayout(jPanelTasks);
        jPanelTasks.setLayout(jPanelTasksLayout);
        jPanelTasksLayout.setHorizontalGroup(
            jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTasksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTasksTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTasksAdd)
                .addGap(15, 15, 15))
        );
        jPanelTasksLayout.setVerticalGroup(
            jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTasksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTasksTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTasksAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelListsList.setBackground(new java.awt.Color(255, 255, 255));
        jPanelListsList.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jListLists.setBackground(new java.awt.Color(255, 255, 255));
        jListLists.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jListLists.setForeground(new java.awt.Color(0, 0, 0));
        jListLists.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListLists.setFixedCellHeight(40);
        jListLists.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jScrollPaneLists.setViewportView(jListLists);

        javax.swing.GroupLayout jPanelListsListLayout = new javax.swing.GroupLayout(jPanelListsList);
        jPanelListsList.setLayout(jPanelListsListLayout);
        jPanelListsListLayout.setHorizontalGroup(
            jPanelListsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListsListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneLists)
                .addContainerGap())
        );
        jPanelListsListLayout.setVerticalGroup(
            jPanelListsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListsListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneLists)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableTasks.setBackground(new java.awt.Color(255, 255, 255));
        jTableTasks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableTasks.setForeground(new java.awt.Color(0, 0, 0));
        jTableTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null,  new Boolean(false)},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null,  new Boolean(false)}
            },
            new String [] {
                "Nome", "Descri��o", "Prazo", "Tarefa Conclu�da"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTasks.setGridColor(new java.awt.Color(204, 204, 204));
        jTableTasks.setRowHeight(40);
        jTableTasks.setRowMargin(1);
        jTableTasks.setSelectionBackground(new java.awt.Color(204, 255, 204));
        jTableTasks.setShowHorizontalLines(true);
        jScrollPaneTasks.setViewportView(jTableTasks);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneTasks, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneTasks)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelLists, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelListsList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelLists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelTasks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelListsList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelListsAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelListsAddMouseClicked
        // Criando uma nova tela de cadastro  
        ListDialogScreen listDialogScreen = new ListDialogScreen(this, rootPaneCheckingEnabled);
        
        // tornando tela visivel
        listDialogScreen.setVisible(true);
        
        // Colocando ouvinte
        listDialogScreen.addWindowListener(new WindowAdapter() {
            // Quando fechar carregar Lista
            public void windowClosed(WindowEvent e) {
                loadLists();
            }
        });
    }//GEN-LAST:event_jLabelListsAddMouseClicked

    private void jLabelTasksAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTasksAddMouseClicked
        // Criado uma nova tela
        TasksDialogScreen taskDialogScreen = new TasksDialogScreen(this, rootPaneCheckingEnabled);
        
        // Setando de qual a Lista dessa tarefa
        //taskDialogScreen.setLista(null);
        
        // tornando tela visivel
        taskDialogScreen.setVisible(true);
    }//GEN-LAST:event_jLabelTasksAddMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelEmptyListIcon;
    private javax.swing.JLabel jLabelEmptyListSubTitle;
    private javax.swing.JLabel jLabelEmptyListTitle;
    private javax.swing.JLabel jLabelListsAdd;
    private javax.swing.JLabel jLabelListsTitle;
    private javax.swing.JLabel jLabelTasksAdd;
    private javax.swing.JLabel jLabelTasksTitle;
    private javax.swing.JLabel jLabelToolbarSubTitle;
    private javax.swing.JLabel jLabelToolbarTitle;
    private javax.swing.JList<String> jListLists;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelEmptyList;
    private javax.swing.JPanel jPanelLists;
    private javax.swing.JPanel jPanelListsList;
    private javax.swing.JPanel jPanelTasks;
    private javax.swing.JPanel jPanelToolbar;
    private javax.swing.JScrollPane jScrollPaneLists;
    private javax.swing.JScrollPane jScrollPaneTasks;
    private javax.swing.JTable jTableTasks;
    // End of variables declaration//GEN-END:variables
    
    public void decorateTableTask() {
        
        // Customizando o Header da Table de Tarefas
        jTableTasks.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 14));
        jTableTasks.getTableHeader().setBackground(new Color(0,153,102));
        jTableTasks.getTableHeader().setForeground(new Color(255,255,255));
        
        // Criando um sort automatico para as colunas 
        jTableTasks.setAutoCreateRowSorter(true);
        
    }
    
    // Metodo para inicializar os controladores
    public void initDataController() {
        // Controladores
        listController = new ListController();
        taskController = new TaskController();
        
    }
    
    // Metodo para inciar Modelo Grafico
    public void initComponetsModel() {
        
        listModel = new DefaultListModel();
        loadLists();
        
        taskModel = new TaskTableModel();
        
        jTableTasks.setModel(taskModel);
        
        
    }
    
    // Metodo para carregar os projetos
    public void loadLists() {
        // Pegando as listas
        List<Lista> listas = listController.getAll();
        
        // Lipando area
        listModel.clear();
        
        // Adcionando as listas na interface
        for (int i = 0; i < listas.size();i ++){
            
            Lista lista = listas.get(i);
            
            listModel.addElement(lista);
        }
        
        jListLists.setModel(listModel);
        
    }
}
