/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RelationshipVisualization.java
 *
 * Created on Oct 21, 2011, 9:52:14 AM
 */
package edu.uwm.cs.molhado.relation;

import edu.cmu.cs.fluid.ir.IRNode;
import edu.cmu.cs.fluid.version.Version;
import edu.cmu.cs.fluid.version.VersionMarker;
import edu.cmu.cs.fluid.version.VersionTracker;
import edu.uwm.cs.molhado.fluid.test.TestTreeGraph;
import edu.uwm.cs.molhado.relation.RelationGraphScene.RelationConflict;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author chengt
 */
public class RelationshipVisualization extends javax.swing.JFrame {

	IRNode root = null;
	RelationGraphScene scene;
	
	/** Creates new form RelationshipVisualization */
	public RelationshipVisualization() {
		initComponents();
		setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.WHITE);
	//	Version v = TestTreeGraph.createRelationshipGraph();
		root = TestTreeGraph.rootNode;
		VersionTracker tracker = new VersionMarker(Version.getInitialVersion());

		scene = new RelationGraphScene(tracker);
		JComponent component = scene.createView();
		jScrollPane1.setViewportView(component);

	//	ArrayList<IRNode> seen = new ArrayList<IRNode>();
//		scene.buildGraph(root, seen );
//		scene.getNodes();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jScrollPane1 = new javax.swing.JScrollPane();
      jButton1 = new javax.swing.JButton();
      jButton2 = new javax.swing.JButton();
      jLabel1 = new javax.swing.JLabel();
      jScrollPane2 = new javax.swing.JScrollPane();
      jTextArea1 = new javax.swing.JTextArea();
      jCheckBox1 = new javax.swing.JCheckBox();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jButton1.setText(org.openide.util.NbBundle.getMessage(RelationshipVisualization.class, "RelationshipVisualization.jButton1.text")); // NOI18N
      jButton1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
         }
      });

      jButton2.setText(org.openide.util.NbBundle.getMessage(RelationshipVisualization.class, "RelationshipVisualization.jButton2.text")); // NOI18N
      jButton2.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
         }
      });

      jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
      jLabel1.setText(org.openide.util.NbBundle.getMessage(RelationshipVisualization.class, "RelationshipVisualization.jLabel1.text")); // NOI18N

      jTextArea1.setColumns(20);
      jTextArea1.setEditable(false);
      jTextArea1.setRows(5);
      jScrollPane2.setViewportView(jTextArea1);

      jCheckBox1.setText(org.openide.util.NbBundle.getMessage(RelationshipVisualization.class, "RelationshipVisualization.jCheckBox1.text")); // NOI18N
      jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jCheckBox1ActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jButton1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jCheckBox1)
            .addGap(23, 23, 23)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
         .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jButton1)
               .addComponent(jButton2)
               .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jCheckBox1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		validateRelationships();
	}//GEN-LAST:event_jButton1ActionPerformed

	private void validateRelationships(){
		jTextArea1.setText("");
		boolean sat = scene.validateRelationships();
		if (sat){
			//jLabel1.setText("No conflict found.");
			//jLabel1.setForeground(Color.GREEN);
			jTextArea1.setText("No conflict found.");
		} else {
			//jLabel1.setText("Found conflicts");
			//jLabel1.setForeground(Color.red);
			ArrayList<RelationConflict> l = scene.getConflicts();
			StringBuilder sb = new StringBuilder();
			sb.append("Found ").append(l.size()).append(" conflicts").append("\n");
			for(RelationConflict c:l){
				sb.append(c.toString()).append("\n");
			}
			jTextArea1.setText(sb.toString());
		}
	}
	
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
		scene.performLayout();
		scene.validate();
	}//GEN-LAST:event_jButton2ActionPerformed

	private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
		scene.setActiveSelect(jCheckBox1.isSelected());
		if (jCheckBox1.isSelected()) validateRelationships();
		// TODO add your handling code here:
	}//GEN-LAST:event_jCheckBox1ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new RelationshipVisualization().setVisible(true);
			}
		});
	}
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton2;
   private javax.swing.JCheckBox jCheckBox1;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JTextArea jTextArea1;
   // End of variables declaration//GEN-END:variables
}