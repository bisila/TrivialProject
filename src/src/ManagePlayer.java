package src;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import src.model.Board;

public class ManagePlayer extends JDialog {

    private JPanel rootPanel, createPlayerPanel, userPlayerPanel;
    private JPanel colorPanel, playerList, gameModePanel;
    private JButton btCreatePlayer, btBorrarJugador, btComenzarPartida;
    private JButton btAzul, btRosa, btAmarillo, btMarron, btVerde, btNaranja;
    private JButton[] colorButtons;
    private JButton rápidaButton, normalButton;
    private JList jListUsePlayer, jListFinalUserPlayer;
    private JTextField tfCrearJugador;
    private String directorio, ruta, gameMode;
    private File playersDirectory;
    public static Boolean estadoDesarrollo = true;
    
    private final ArrayList<String> arrayPlayer = new ArrayList<>();
    private final ArrayList<Player> arrayFinalPlayer = new ArrayList<>();
    private final ArrayList<String> arrayFinalNamePlayer = new ArrayList<>();

    private int selectedItemPlayerList, selectedItemPartyList;

    public ManagePlayer(JFrame frame, boolean modality) {
        super(frame, modality);
        setContentPane(rootPanel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        initializeComponents();
        initializeListPlayer();
        initializeColoursArray();
        
        addActionListenerCreatePlayer();
        addActionListenerComenzarPartida(frame);
        addActionListenerBorrarJugador();

        addActionListenerToColor(btAmarillo);
        addActionListenerToColor(btMarron);
        addActionListenerToColor(btRosa);
        addActionListenerToColor(btNaranja);
        addActionListenerToColor(btAzul);
        addActionListenerToColor(btVerde);
        addgameModeActionListeners();
        setVisible(true);
    }

    public ArrayList<Player> getArrayFinalPlayer() {
        return arrayFinalPlayer;
    }

    private void initializeComponents() {
        //Este es el directorio de trabajo cuando tenemos la versión final
        if (estadoDesarrollo) {
            directorio = System.getProperty("user.dir");
        } else {
            //Este es el directorio de trabajo cuando tenemos la versión final
            directorio = System.getProperty("java.class.path");
            File dir = new File(directorio);
            directorio = dir.getParent();
        }
        ruta = directorio + "/src/player/";
        playersDirectory = new File(ruta);
    }
    
    private void initializeListPlayer() {
        jListUsePlayer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jListUsePlayer.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        jListFinalUserPlayer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jListFinalUserPlayer.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        //Recoge todos los archivos del directorio que cumplan con la condición en la clase main
        if (playersDirectory.isDirectory()) {
            File[] list = playersDirectory.listFiles();
            for (int i = list.length; --i >= 0; ) {
                arrayPlayer.add(list[i].getName());
            }
            jListUsePlayer.setListData(arrayPlayer.toArray());
        }
    }
    
    private void initializeColoursArray() {
        colorButtons = new JButton[]{btAmarillo, btAzul, btMarron, btNaranja, btRosa, btVerde};
        for (JButton colorButton : colorButtons) {
            colorButton.setFocusPainted(false);
        }
    }
    
    private void addActionListenerCreatePlayer() {
        btCreatePlayer.setFocusPainted(false);
        btCreatePlayer.addActionListener(e -> {
            String playerName = tfCrearJugador.getText();
            
            try {
                // declaramos la variable playersDirectory como un objeto File y le asignamos una ruta donde se creará
                playersDirectory = new File(ruta + playerName);
                if (!playersDirectory.exists()) {
                    FileWriter escribir = new FileWriter(playersDirectory, true);
                    escribir.close();
                    tfCrearJugador.setText(""); //Limpiamos el JTextArea si hubiera algo
                    arrayPlayer.add(playerName);
                    jListUsePlayer.setListData(arrayPlayer.toArray());
                    JOptionPane.showMessageDialog(rootPanel, "Jugador creado con éxito");
                } else {
                    JOptionPane.showMessageDialog(rootPanel, "El jugador ya existe");
                }
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(rootPanel, "Error crear archivo");
            }
        });
    }
    
    private void addActionListenerComenzarPartida(JFrame frame) {
        btComenzarPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arrayFinalNamePlayer.isEmpty())
                    JOptionPane.showMessageDialog(rootPanel, "Seleccione al menos un jugador para comenzar la partida");
                else if (gameMode == null){
                    JOptionPane.showMessageDialog(rootPanel, "Seleccione un modo de partida");
                }
                else {
                    dispose();
                    frame.dispose();
                    launchBoardFrame();
                }
            }

            private void launchBoardFrame() {
                Board board = new Board(arrayFinalPlayer);
                BoardFrame boardFrame = new BoardFrame(board);
                boardFrame.setLocationRelativeTo(null);
                boardFrame.setVisible(true);
            }
        });
    }

    private void addActionListenerBorrarJugador() {
        btBorrarJugador.setFocusPainted(false);
        btBorrarJugador.addActionListener(e -> checkDeletePlayer(jListUsePlayer.getSelectedIndex()));
    }
    
    private void addActionListenerToColor(JButton button) {
        button.addActionListener(e -> {
            selectedItemPlayerList = jListUsePlayer.getSelectedIndex();
            selectedItemPartyList = jListFinalUserPlayer.getSelectedIndex();
            if (selectedItemPlayerList != -1){
                addPlayerToParty(selectedItemPlayerList, button.getBackground());
                refreshButton(button, arrayPlayer.get(selectedItemPlayerList));
                refreshList(arrayPlayer, jListUsePlayer);    
            }
            else if (selectedItemPartyList != -1) {
                changePlayerColor(selectedItemPartyList, button);
            }
            else{
                JOptionPane.showMessageDialog(rootPanel, "Debe elegir un jugador");
            }
        });
    }
    
    private void refreshList(ArrayList<String> arrayPlayer, JList jListUsePlayer) {
        arrayPlayer.remove(selectedItemPlayerList);
        jListUsePlayer.setListData(arrayPlayer.toArray());
    }

    private void refreshButton(JButton button, String s) {
        button.setEnabled(false);
        button.setText(arrayPlayer.get(selectedItemPlayerList));
    }

    private void changePlayerColor(int selectedIndex, JButton button) {
        button.setEnabled(false);
        for (JButton colorButton : colorButtons) {
            if (colorButton.getBackground().equals(getPlayerFromPartyAtIndex(selectedIndex).getColor())){
                colorButton.setText(" ");
                colorButton.setForeground(colorButton.getBackground());
                colorButton.setEnabled(true);
            }    
        }
        button.setText(getPlayerNameFromPartyAtIndex(selectedIndex));
        getPlayerFromPartyAtIndex(selectedIndex).setColor(button.getBackground());
    }

    private Player getPlayerFromPartyAtIndex(int selectedIndex) {
        return arrayFinalPlayer.get(selectedIndex);
    }

    private String getPlayerNameFromPartyAtIndex(int selectedIndex) {
        return arrayFinalNamePlayer.get(selectedIndex);
    }

    private void addPlayerToParty(int selectedIndex, Color color) {
        Player player = new Player(arrayPlayer.get(selectedIndex), color);
        arrayFinalNamePlayer.add(player.getName());
        arrayFinalPlayer.add(player);
        jListFinalUserPlayer.setListData(arrayFinalNamePlayer.toArray());
    }

    private void checkDeletePlayer(int selectedIndex) {
        if (selectedIndex != -1) {
            removePlayer(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(rootPanel, "Debe elegir un jugador");
        }
    }

    private void removePlayer(int selection) {
        File fichero = new File(ruta + arrayPlayer.get(selection));

        if (fichero.delete())
            JOptionPane.showMessageDialog(rootPanel, "El jugador ha sido borrado");
        else
            JOptionPane.showMessageDialog(rootPanel, "El fichero no puede ser borrado");

        arrayPlayer.remove(selection);
        jListUsePlayer.setListData(arrayPlayer.toArray());
    }
    
    private void addgameModeActionListeners(){
        rápidaButton.setFocusPainted(false);
        normalButton.setFocusPainted(false);
        rápidaButton.addActionListener((ActionEvent e) -> {
            gameMode = "Rápida";
            rápidaButton.setBackground(Color.GREEN);
            normalButton.setBackground(null);
        });
        normalButton.addActionListener((ActionEvent e) -> {
            gameMode = "Normal";
            normalButton.setBackground(Color.GREEN);
            rápidaButton.setBackground(null);
        });
    }
    
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 5, new Insets(15, 15, 15, 15), -1, -1));
        rootPanel.setPreferredSize(new Dimension(800, 300));
        createPlayerPanel = new JPanel();
        createPlayerPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(2, 2, 2, 2), -1, -1));
        createPlayerPanel.putClientProperty("html.disable", Boolean.FALSE);
        rootPanel.add(createPlayerPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        createPlayerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Crear Jugador", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        tfCrearJugador = new JTextField();
        createPlayerPanel.add(tfCrearJugador, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        createPlayerPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        btCreatePlayer = new JButton();
        btCreatePlayer.setLabel("Crear");
        btCreatePlayer.setText("Crear");
        createPlayerPanel.add(btCreatePlayer, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        userPlayerPanel = new JPanel();
        userPlayerPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(2, 2, 2, 2), -1, -1));
        rootPanel.add(userPlayerPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(156, 97), null, 0, false));
        userPlayerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Usar jugador", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        jListUsePlayer = new JList();
        jListUsePlayer.setFont(new Font("Aharoni", Font.PLAIN, 12));
        final DefaultListModel defaultListModel1 = new DefaultListModel();
        jListUsePlayer.setModel(defaultListModel1);
        jListUsePlayer.setName("");
        userPlayerPanel.add(jListUsePlayer, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(155, 25), null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        userPlayerPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(155, 36), null, 0, false));
        btBorrarJugador = new JButton();
        btBorrarJugador.setText("Borrar Jugador");
        panel1.add(btBorrarJugador, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        colorPanel = new JPanel();
        colorPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 1, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.add(colorPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        colorPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Elige color", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        btAzul = new JButton();
        btAzul.setBackground(new Color(-15777174));
        btAzul.setForeground(new Color(-15777174));
        btAzul.setText("Azul");
        colorPanel.add(btAzul, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btRosa = new JButton();
        btRosa.setBackground(new Color(-62288));
        btRosa.setForeground(new Color(-62288));
        btRosa.setText("Rosa");
        colorPanel.add(btRosa, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btAmarillo = new JButton();
        btAmarillo.setBackground(new Color(-1280));
        btAmarillo.setForeground(new Color(-1280));
        btAmarillo.setText("Amarillo");
        colorPanel.add(btAmarillo, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btMarron = new JButton();
        btMarron.setBackground(new Color(-12506599));
        btMarron.setForeground(new Color(-12506599));
        btMarron.setText("Marron");
        colorPanel.add(btMarron, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btVerde = new JButton();
        btVerde.setBackground(new Color(-14794458));
        btVerde.setForeground(new Color(-14794458));
        btVerde.setText("Verde");
        colorPanel.add(btVerde, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btNaranja = new JButton();
        btNaranja.setBackground(new Color(-6396928));
        btNaranja.setForeground(new Color(-6396928));
        btNaranja.setText("Naranja");
        colorPanel.add(btNaranja, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        playerList = new JPanel();
        playerList.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(2, 2, 2, 2), -1, -1));
        rootPanel.add(playerList, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        playerList.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Jugadores", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        jListFinalUserPlayer = new JList();
        playerList.add(jListFinalUserPlayer, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        btComenzarPartida = new JButton();
        btComenzarPartida.setText("Comenzar Partida");
        rootPanel.add(btComenzarPartida, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(156, 32), null, 0, false));
        gameModePanel = new JPanel();
        gameModePanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.add(gameModePanel, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        gameModePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Elegir tipo de partida"));
        rápidaButton = new JButton();
        rápidaButton.setText("Rápida");
        gameModePanel.add(rápidaButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        normalButton = new JButton();
        normalButton.setText("Normal");
        gameModePanel.add(normalButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @return 
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }
}