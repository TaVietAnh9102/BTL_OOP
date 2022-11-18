package models;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                DefaultTableModel model = new DefaultTableModel(new String[]{"People", "Place", "Organisation", "Event", "Mentions"}, 0);
                model.addRow(new Object[]{"Prankster", "USA", "Microsoft Pvt Ltd", "Party'14", 900000});
                model.addRow(new Object[]{"Ramanuj", "India", "Tata Consultancy", "Party'14", 500000});
                model.addRow(new Object[]{"Banana", "India", "Tata Consultancy", "Party'14", 500000});
                
                JTable table = new JTable(model);
                TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
                table.setRowSorter(sorter);

                List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
                sortKeys.add(new RowSorter.SortKey(4, SortOrder.DESCENDING));
                sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
                sorter.setSortKeys(sortKeys);
                
                model.addRow(new Object[]{"a", "a", "a", "a", 900001});
                model.setValueAt(1, 0, 4);
                sorter.allRowsChanged();;
              //  TableRowSorter<TableModel> sorter2 = new TableRowSorter<TableModel>(table.getModel());
                //sorter2.setSortKeys(sortKeys);
                
                model.setValueAt(2, 2, 4);
                sorter.allRowsChanged();
               
                
                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}