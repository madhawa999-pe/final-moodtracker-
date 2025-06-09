import javax.swing.*;
import javax.swing.event.ChangeListener;

class moodSwingUI{
	private JournalMan journalMan;
	
	public moodSwingUI(){ //main ui class with tabbed interface for the mood tracker
	 journalMan = new JournalMan();
	 
	    JFrame frame = new JFrame("Mood Tracker"); //create main frame
        frame.setSize(1000,718);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();//tabbed pane to switch between views

        MoodInputTab inputTab = new MoodInputTab(journalMan); //two main tabs for input and view
        MoodViewTab viewTab = new MoodViewTab(journalMan);

        tabs.addTab("New Entry", inputTab.getPanel());//for new mmod entries
        tabs.addTab("Saved Entries", viewTab.getPanel()); //for viewing previous entries
		
		tabs.addChangeListener(e ->{ // when user switches to "saved entries" and update the list
			int selectedIndex = tabs.getSelectedIndex();
            String selectedTitle = tabs.getTitleAt(selectedIndex);
			if (selectedTitle.equals("Saved Entries")){
				viewTab.showEntries();
			}
		});
		frame.add(tabs);//add tabs to frame and display
		frame.setVisible(true);
	 
	}
	public static void launch(){
	SwingUtilities.invokeLater(new Runnable(){
		public void run(){
			new moodSwingUI();
		}
		
	});
}

}

