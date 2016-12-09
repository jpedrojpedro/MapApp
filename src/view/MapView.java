package view;

import handler.DrawCircleHandler;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import model.Toast;
import org.jdesktop.swingx.JXMapKit;
import org.jdesktop.swingx.JXMapKit.DefaultProviders;
import org.jdesktop.swingx.mapviewer.GeoPosition;

public class MapView extends Window implements ActionListener
{
	private static final long serialVersionUID = -2161301061384667275L;
	/** Button images */
	private Icon truckLogo = new ImageIcon(getClass().getResource("/images/truckLogo.png"), 
			   							   "Truck Logo");
	private Icon perLogo = new ImageIcon(getClass().getResource("/images/perimeterLogo.png"), 
			   							   "Perimeter Logo");
	/** Operational buttons */
	private JButton truckButton = new JButton(truckLogo);
	private JButton perButton = new JButton(perLogo);
	/** Panels */
	private JPanel menu = new JPanel(new FlowLayout());
	private JPanel groups = new JPanel(new BorderLayout());
	/** Split Panels */
	private JSplitPane hideMenu = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	private JSplitPane hideGroups = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	/** Defined Groups Tree */
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("Defined Groups");
	private JTree groupTree = new JTree(root);
	/** The Map */
	private JXMapKit mapKit = new JXMapKit();
	/** Glass Component */
	private JPanel glassPane;
	/** Wrap Container */
	private Container c;
	
	public MapView ()
	{
		super ( 800, 600 );
		c = this.getContentPane();
		try
		{	
			/** Instance of map */
			this.mapKit = new JXMapKit();
			this.mapKit.setDefaultProvider(DefaultProviders.OpenStreetMaps);
			this.mapKit.getMiniMap().setVisible(false);
			this.mapKit.setAddressLocation(new GeoPosition(-22.980204, -43.233656));
			
			/** Setting the frame title */
			this.setTitle("Gerenciamento de Nos Moveis");
			
			/** Setting toll tip button information */
			this.truckButton.setToolTipText("Select Truck");
			this.perButton.setToolTipText("Select Perimeter");
			
			/** Adding buttons to menu panel */
			this.menu.add(this.truckButton);
			this.menu.add(this.perButton);
			
			/** Adding map and menu on split panel - hideMenu */
			this.hideMenu.add(mapKit);
			this.hideMenu.add(this.menu);
			this.hideMenu.setOneTouchExpandable(true);
			this.hideMenu.setDividerLocation(400);
			
			/** Adding hideMenu and groupTree on split panel - hideGroups */
			this.groups.add(this.groupTree);
			this.hideGroups.add(this.hideMenu);
			this.hideGroups.add(this.groups);
			this.hideGroups.setOneTouchExpandable(true);
			this.hideGroups.setDividerLocation(658);
			
			/** Adding split panels on container */
			c.add(this.hideGroups);
			
			/** Setting listeners */
			this.perButton.addActionListener(this);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "Erro ao conectar com o Mapa "
												+ e.getMessage());
		}
	}

	public JXMapKit getMapKit()
	{
		return mapKit;
	}
	
	public void addGroup (String groupName)
	{
		DefaultMutableTreeNode newGroup = new DefaultMutableTreeNode(groupName);
		this.root.add(newGroup);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// action for perimeter Button
		if ( e.getSource().equals(this.perButton) )
		{
			this.glassPane = new DrawCircle();
			this.glassPane.setOpaque(false);
			this.setGlassPane(this.glassPane);
			this.glassPane.setVisible(true);
			try
			{
				new Toast("Gerenciamento de Nos Moveis", 
						  "Modulo de criacao de Grupo Implicito " +
						  "habilitado");
			}
			catch (AWTException ex)
			{
				System.out.println(ex.getMessage());
			}
			finally
			{
				new DrawCircleHandler((DrawCircle) this.glassPane);
			}
		}
	}
}
