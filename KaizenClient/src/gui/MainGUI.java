package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import state.CreateHabitState;
import state.HabitsState;
import state.HomeState;
import state.JournalState;
import state.State;
import state.TodoState;
import state.UpdateHabitsState;
import util.Debug;

public class MainGUI extends JFrame {

	private static final long serialVersionUID = -6508626185123863757L;
	private final Debug debug = new Debug(true);
	
	/**
	 * The top menu bar
	 */
	private JMenuBar menuBar;
	
	/**
	 * Menus and associated items
	 */
	private JMenu homeMenu;
	private JMenuItem customizeHomeMenuItem;
	
	private JMenu todoMenu;
	private JMenuItem printToDoMenuItem;
	
	private JMenu habitsMenu;
	private JMenuItem createHabitMenuItem;
	private JMenuItem updateHabitsMenuItem;
	
	private JMenu journalMenu;
	private JMenuItem printJournalMenuItem;
	
	private JMenu relationshipsMenu;
	private JMenuItem createRelationshipMenuItem;
	private JMenuItem updateRelationshipsMenuItem;
	
	/**
	 * The current state of Kaizen
	 */
	private State state;
	
	public MainGUI() {
		initMemberVariables();
		initComponents();
		initComponentActions();
		addComponentsToFrame();
		initFrame();
	}
	
	private void initMemberVariables() {
		state = new HomeState();
	}
	
	private void initComponents() {
		menuBar = new JMenuBar();
		
		homeMenu = new JMenu("Home");
		customizeHomeMenuItem = new JMenuItem("Customize Home");
		
		todoMenu = new JMenu("Todo");
		printToDoMenuItem = new JMenuItem("Print Todo");
		printToDoMenuItem.setEnabled(false);
		
		habitsMenu = new JMenu("Habits");
		createHabitMenuItem = new JMenuItem("Start Habit");
		updateHabitsMenuItem = new JMenuItem("Update Habits");
		
		journalMenu = new JMenu("Journal");
		printJournalMenuItem = new JMenuItem("Print Journal");
		printJournalMenuItem.setEnabled(false);
		
		relationshipsMenu = new JMenu("Relationships");
		createRelationshipMenuItem = new JMenuItem("Add Relationship");
		updateRelationshipsMenuItem = new JMenuItem("Update Relationships");
	}
	
	private void initComponentActions() {
		homeMenu.addMenuListener(new MenuListener() {
			@Override
			public void menuSelected(MenuEvent e) {
				if(!(state instanceof HomeState)) {
					debug.print("Home Menu selected, changing to Home State");
					changeState(new HomeState());
				} else {
					debug.print("Home Menu selected, but already in state. Will not reload state.");
				}
			}
			@Override
			public void menuDeselected(MenuEvent e) {}
			@Override
			public void menuCanceled(MenuEvent e) {}
			
		});
		todoMenu.addMenuListener(new MenuListener() {
			@Override
			public void menuSelected(MenuEvent e) {
				if(!(state instanceof TodoState)) {
					debug.print("Todo Menu selected, changing to Todo State");
					changeState(new TodoState());
				} else {
					debug.print("Todo Menu selected, but already in state. Will not reload state.");
				}
			}
			@Override
			public void menuDeselected(MenuEvent e) {}
			@Override
			public void menuCanceled(MenuEvent e) {}
			
		});
		habitsMenu.addMenuListener(new MenuListener() {
			@Override
			public void menuSelected(MenuEvent e) {
				if(!(state instanceof HabitsState)) {
					debug.print("Habits Menu selected, changing to Habits State");
					changeState(new HabitsState());
				} else {
					debug.print("Habits Menu selected, but already in state. Will not reload state.");
				}
			}
			@Override
			public void menuDeselected(MenuEvent e) {}
			@Override
			public void menuCanceled(MenuEvent e) {}
			
		});
		createHabitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(state instanceof CreateHabitState)) {
					debug.print("CreateHabit Menu selected, changing to CreateHabit State");
					changeState(new CreateHabitState());
				} else {
					debug.print("CreateHabit Menu selected, but already in state. Will not reload state.");
				}
			}
		});
		updateHabitsMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(state instanceof UpdateHabitsState)) {
					debug.print("UpdateHabit Menu selected, changing to UpdateHabit State");
					changeState(new UpdateHabitsState());
				} else {
					debug.print("UpdateHabit Menu selected, but already in state. Will not reload state.");
				}
			}
		});
		journalMenu.addMenuListener(new MenuListener() {

			@Override
			public void menuSelected(MenuEvent e) {
				if(!(state instanceof JournalState)) {
					debug.print("JournalState Menu selected, changing to JournalState State");
					changeState(new JournalState());
				} else {
					debug.print("JournalState Menu selected, but already in state. Will not reload state.");
				}
			}
			@Override
			public void menuDeselected(MenuEvent e) {}
			@Override
			public void menuCanceled(MenuEvent e) {}
		});
	}
	
	private void addComponentsToFrame() {
		//MenuBar
		menuBar.add(homeMenu);
		
		homeMenu.add(customizeHomeMenuItem);
		
		menuBar.add(todoMenu);
		
		todoMenu.add(printToDoMenuItem);
		
		menuBar.add(habitsMenu);
		
		habitsMenu.add(createHabitMenuItem);
		habitsMenu.add(updateHabitsMenuItem);
		
		menuBar.add(journalMenu);
		
		journalMenu.add(printJournalMenuItem);
		
		menuBar.add(relationshipsMenu);
		
		relationshipsMenu.add(createRelationshipMenuItem);
		relationshipsMenu.add(updateRelationshipsMenuItem);
		
		this.add(menuBar, BorderLayout.NORTH);
		
		//State
		this.add(state);
	}
	
	
	private void initFrame() {
		this.setTitle("Kaizen Alpha v0.1");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(900, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void changeState(State newState) {
		this.remove(state);
		this.setSize(900, 699);
		state = newState;
		this.add(state);
		this.repaint();
		this.setSize(900, 700);
	}

}
