package app.frames;

import app.Sistema.Sistema;
import app.Sistema.ChatMessage;
import app.Sistema.ChatMessage.Action;
import app.Sistema.ClienteService;
import app.tests.MessageConsole;
import criptografia.*;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Vinicius Dutra Cerqueira Rocha - 315112918
 *
 * @version 5.0
 *
 */
public class ClientInterface extends javax.swing.JFrame {

    private Socket socketTeste;
    private ChatMessage message;
    private ClienteService service;
    private String nome = null;
    private String servidor = null;
    boolean isConected = false;
    
    static EncriptaDecriptaDES_v3 classeDES = new EncriptaDecriptaDES_v3();
    static AES classeAES = new AES();
    static Cifrarsa classeRSA = new Cifrarsa();
    
    static Sistema sys = new Sistema();
    int tpCrypt = 0;
    Opcoes frameOpecoes;    
    static SecretKey chaveDESECB = null;
    static SecretKey chaveDESCBC = null;
    static String chaveAES = null;
    File autolog;// = new File("teslog.logSc");
    String Data = new SimpleDateFormat("[dd_MM_yyyy-HH_mm_ss]").format(new Date(System.currentTimeMillis()));
    String DataMSG;
    String validaCrypt = "";
    byte[] txtbyte = null;
    TelaConsole console = new TelaConsole();

    public ClientInterface() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaReceive = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaSend = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        IPLabel = new javax.swing.JLabel();
        IP_Status = new javax.swing.JToolBar.Separator();
        jLabel4 = new javax.swing.JLabel();
        StatusLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Status_Crypto = new javax.swing.JToolBar.Separator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        RelogioStatus = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listOnlines = new javax.swing.JList();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnConnectar = new javax.swing.JMenuItem();
        btnSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MenuOpcoes = new javax.swing.JMenuItem();
        BotaoSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtAreaReceive.setEditable(false);
        txtAreaReceive.setColumns(20);
        txtAreaReceive.setRows(5);
        txtAreaReceive.setEnabled(false);
        jScrollPane1.setViewportView(txtAreaReceive);

        txtAreaSend.setEditable(false);
        txtAreaSend.setColumns(20);
        txtAreaSend.setRows(5);
        txtAreaSend.setEnabled(false);
        jScrollPane3.setViewportView(txtAreaSend);

        btnEnviar.setText("Enviar");
        btnEnviar.setEnabled(false);
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Cancelar");
        btnLimpar.setEnabled(false);
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jToolBar1.setFloatable(false);

        jLabel1.setText("Seu ip : ");
        jToolBar1.add(jLabel1);

        IPLabel.setText("0.0.0.0                    ");
        jToolBar1.add(IPLabel);
        jToolBar1.add(IP_Status);

        jLabel4.setText("    ");
        jToolBar1.add(jLabel4);

        StatusLabel.setText(" Desconectado");
        jToolBar1.add(StatusLabel);

        jLabel5.setText("      ");
        jToolBar1.add(jLabel5);
        jToolBar1.add(Status_Crypto);

        jLabel2.setText("                                                         ");
        jToolBar1.add(jLabel2);
        jToolBar1.add(jSeparator4);

        RelogioStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RelogioStatus.setText("00:00:00");
        jToolBar1.add(RelogioStatus);

        listOnlines.setToolTipText("");
        listOnlines.setEnabled(false);
        jScrollPane2.setViewportView(listOnlines);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                    .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(11, 11, 11)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2))
                .addGap(6, 6, 6)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("Menu");

        btnConnectar.setText("Conectar");
        btnConnectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectarActionPerformed(evt);
            }
        });
        jMenu1.add(btnConnectar);

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jMenu1.add(btnSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Opcoes");

        MenuOpcoes.setText("Opcoes");
        MenuOpcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuOpcoesActionPerformed(evt);
            }
        });
        jMenu2.add(MenuOpcoes);

        BotaoSobre.setText("Sobre");
        BotaoSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSobreActionPerformed(evt);
            }
        });
        jMenu2.add(BotaoSobre);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

        DataMSG = new SimpleDateFormat("[HH:mm:ss]").format(new Date(System.currentTimeMillis()));
        System.out.println("|*******************************************|");
        /*
         Primeiro if valida se foi digitado alguma coisa antes de enviar para os outros clientes.
         */
        if (txtAreaSend.getText().isEmpty() || txtAreaSend.getText().equals(null)) {
            JOptionPane.showMessageDialog(null, "Não é possivel enviar mensagens em branco",
                    "Não é possivel enviar mensagens em branco", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String text = this.txtAreaSend.getText();
            String name = this.message.getName();
            String textOld = "";
            textOld =text;

            /*
             É criado um novo objeto do tipo ChatMessage para armazenar a mensagem a ser enviada
             o setCrypt é armazenado qual o tipo de criptografia escolido
             */
            this.message = new ChatMessage();
            this.message.setTpCrypt(tpCrypt);
            this.message.setName(name);

            /*
             Ponto de Log para exibir no console o tipo de criptografia
             */
            sys.EscreveLogConsole("ClienteInterface - Metodo btnEnviar[TpCrypt]", "tpCrypt : " + tpCrypt);
            sys.EscreveLogConsole("ClienteInterface - Metodo btnEnviar[TpCrypt]", "this.tpCrypt : " + this.message.getTpCrypt());

            //Ponto de log para exibir no console o valor da variavel isConnected.            
            sys.EscreveLogConsole("ClienteInterface - Metodo btnEnviar", "[" + this.message.getName() + "]" + "isConnected : " + isConected);
            sys.EscreveLogConsole("ClienteInterface - Metodo btnEnviar[TpCrypt]", "textOld : " + textOld);
            ValidaCriptoBtnEnviaMsg(textOld);
            /*            
             Validação se foi selecionado apenas um cliente para envio de mensagem
             */
            if (this.listOnlines.getSelectedIndex() > -1) {
                this.message.setNameReserved((String) this.listOnlines.getSelectedValue());
                this.message.setAction(Action.SEND_ONE);
                this.listOnlines.clearSelection();
            } else {
                this.message.setAction(Action.SEND_ALL);
            }

            this.txtAreaReceive.append( DataMSG + "Voce disse : " + textOld + "\n");

            System.out.println("|*******************************************|");
            this.service.send(this.message);
            this.txtAreaSend.setText(null);

        }

    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        if (isConected == true) {
            if (JOptionPane.showConfirmDialog(null, "Voce ainda esta conectado ao Servidor : " + servidor + "\n"
                    + "Voce realmente gostaria de se desconectar e sair?", "Pergunta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                disconnected();

            } else {
                return;
            }
        } else {

        }


    }//GEN-LAST:event_btnSairActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtAreaSend.setText(null);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void BotaoSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSobreActionPerformed
        JOptionPane.showMessageDialog(null, "    Desenvolvido por : \n Breno Lopes de Lima - 31312514\n"
                + " Vinicius Dutra Cerqueira Rocha - 315112918\n"
                + " Kepler Nicolai Alves Freitas  - 31222198"
                + "\nVersao 5.3" + "\nDezembro 2015 ", "Sobre a aplicacao", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_BotaoSobreActionPerformed

    private void MenuOpcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuOpcoesActionPerformed
        if (frameOpecoes == null) {
            frameOpecoes = new Opcoes();
            frameOpecoes.setVisible(true);
        } else {
            frameOpecoes.setVisible(true);
            frameOpecoes.setState(frameOpecoes.NORMAL);
        }
        tpCrypt = frameOpecoes.RetornaTPCrypt();

        sys.EscreveLogConsole("MenuOpcoesActionPerformed","--------------------------------------");
        sys.EscreveLogConsole("MenuOpcoesActionPerformed", "Usuario : " + nome);
        sys.EscreveLogConsole("MenuOpcoesActionPerformed", "Valor tpCrypt : " + tpCrypt);
        sys.EscreveLogConsole("MenuOpcoesActionPerformed","--------------------------------------");
    }//GEN-LAST:event_MenuOpcoesActionPerformed

    private void btnConnectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectarActionPerformed

        servidor = JOptionPane.showInputDialog("Informe o Ip do servidor : ");
        nome = JOptionPane.showInputDialog("Digite seu nome : ");
        boolean aux = validaDados(servidor, nome);
        if (aux) {

            this.message = new ChatMessage();

             sys.EscreveLogConsole("btnConnectarActionPerformed","[antes do if]TpCrypt : " + tpCrypt);

            /*
             ** Validação nova :                
             ---------------------*/
            Object[] tiposCripto = {"DES - CBC", "DES - ECB", "AES - CBC", "AES - ECB", "RSA"};
            Object tex = JOptionPane.showInputDialog(null, "Voce nao informou qual tipo de criptografia irá utilizar. Informe o tipo de criptografia a ser utilizado", "Escolha de Criptografia", JOptionPane.INFORMATION_MESSAGE, null, tiposCripto, "DES - CBC");
            sys.EscreveLogConsole("btnConnectarActionPerformed","Tipo de Criptografia Selecionada : " + tex);

            if (tex == "DES - ECB") {
                tpCrypt = 2; //DES - encryptCBC
            } else if (tex == "DES - CBC") {
                tpCrypt = 3; //DES - DESPaddingECB
            } else if (tex == "AES - CBC") {
                tpCrypt = 4; //AES - CBC
            } else if (tex == "AES - ECB") {
                tpCrypt = 5; //AES - ECB
            } else if (tex == "RSA") {
                tpCrypt = 6; //RSA
            }
 
            txtAreaSend.setEnabled(true);

            this.message.setAction(Action.CONNECT);
            this.message.setName(nome);
            this.message.setTpCrypt(tpCrypt);
            sys.EscreveLogConsole("btnConnectarActionPerformed","[depois do If]TpCrypt : " + tpCrypt);
            sys.EscreveLogConsole("btnConnectarActionPerformed","[this.message.getTpCrypt()]TpCrypt : " + this.message.getTpCrypt());
            this.service = new ClienteService();
            this.socketTeste = this.service.connect(servidor);
            
            sys.EscreveLogConsole("btnConnectarActionPerformed","--------------------------------------");
            sys.EscreveLogConsole("btnConnectarActionPerformed","Usuario : " + nome);
            sys.EscreveLogConsole("btnConnectarActionPerformed","Conectado no Servidor : " + servidor);
            sys.EscreveLogConsole("btnConnectarActionPerformed","Criptografia Selecionada : " + tex);
            sys.EscreveLogConsole("btnConnectarActionPerformed","TpCript : " + tpCrypt);
            sys.EscreveLogConsole("btnConnectarActionPerformed","--------------------------------------");
            
            new Thread(new ListenerSocket(this.socketTeste)).start();
            this.service.send(message);

            

            //Altera o titulo da janela exibindo o nome do usuário e o ip/endereco do servidor e status da cryptografia
            validaCrypt = (this.message.getTpCrypt() == 0) ? "Desativada" : "Ativada";
            validaCrypt = (this.message.getTpCrypt() == 2) ? "[DES-ECB]Ativada" : "[DES]Desativada";
            validaCrypt = (this.message.getTpCrypt() == 3) ? "[DES-CBC]Ativada" : "[DES]Desativada";
            validaCrypt = (this.message.getTpCrypt() == 4) ? "[AES]Ativada" : "[AES]Desativada";
            validaCrypt = (this.message.getTpCrypt() == 5) ? "[AES]Ativada" : "[AES]Desativada";
            validaCrypt = (this.message.getTpCrypt() == 6) ? "[RSA]Ativada" : "[RSA]Desativada";
            this.setTitle(nome + " conectado no Servidor : " + servidor + " Criptografia : " + validaCrypt);

            btnConnectar.setEnabled(false);
            txtAreaSend.setEditable(true);
            isConected = true;
            
        } else {
            isConected = false;
        }
        AutoLog();


    }//GEN-LAST:event_btnConnectarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        Thread tr = new Thread(new Runnable() {

            @Override
            public void run() {
                int i = 0;
                while (true) {
                    Date data = new Date();
                    String hora = new SimpleDateFormat("kk:mm:ss").format(data);
                    RelogioStatus.setText(String.valueOf(hora));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {

                    }
                }
            }
        });
        tr.start();
        IPLabel.setText(say());

    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        autolog = new File("C:\\LogsCripto\\[Cliente]" + Data + "_autoLog_" + nome + ".logSc");
        sys.EscreveLogConsole("ClienteInterface - Metodo formWindowClosed", "INICIO");
        if (isConected == true) {
            /*
             Validação caso o usuário esteja conectado ao servidor, e ´questionado ao usuário se realmente ele quer sair do chat
             */
            if (JOptionPane.showConfirmDialog(null, "Voce ainda esta conectado ao Servidor : " + servidor + "\n"
                    + "Voce realmente gostaria de se desconectar e sair?", "Pergunta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                disconnected();
                sys.EscreveLogConsole("ClienteInterface - Metodo formWindowClosed", "[Desconectando]FIM disconnected");
                sys.EscreveLog(console.jTextArea1.getText(), autolog);
                System.exit(0);
            } else {
                return;
            }
        } else {
            sys.EscreveLogConsole("ClienteInterface - Metodo formWindowClosed", "FIM ELSE");
            sys.EscreveLog(console.jTextArea1.getText(), autolog);
            System.exit(0);
        }


    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BotaoSobre;
    private javax.swing.JLabel IPLabel;
    private javax.swing.JToolBar.Separator IP_Status;
    private javax.swing.JMenuItem MenuOpcoes;
    private javax.swing.JLabel RelogioStatus;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JToolBar.Separator Status_Crypto;
    private javax.swing.JMenuItem btnConnectar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JMenuItem btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JList listOnlines;
    private javax.swing.JTextArea txtAreaReceive;
    private javax.swing.JTextArea txtAreaSend;
    // End of variables declaration//GEN-END:variables

    /**
     * Metodo para realizar a validação dos dados inseridos pelo usuário
     *
     * @param server ip do servidor
     * @param name nome do usuário a ser conectado
     * @return retorna verdade se somente se se os dados inseridos pelo usuário
     * estão válidos
     */
    private boolean validaDados(String server, String name) {
        boolean aux = false;
        if (server == null || server.isEmpty() || server.equals("")) {

            if (JOptionPane.showConfirmDialog(null, "Voce nao digitou nenhum ip de servidor\n"
                    + "Voce gostaria de informar o ip do servidor?", "Ip do servidor",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                servidor = JOptionPane.showInputDialog("Informe o Ip do servidor : ");
                aux = true;
            } else {
                JOptionPane.showMessageDialog(null, "Voce nao informou o servidor,seu status atual eh:Desconcetado", "Mensagem",
                        JOptionPane.INFORMATION_MESSAGE);
                StatusLabel.setText("OffLine");
                //isConected = false;
                txtAreaSend.setEditable(false);
                txtAreaReceive.setEnabled(false);
                btnEnviar.setEnabled(false);
                btnLimpar.setEnabled(false);
                aux = false;
            }

        } else {
            aux = true;
        }

        if (name == null || name.isEmpty() || name.equals("")) {

            if (JOptionPane.showConfirmDialog(null, "Voce nao digitou um nome/apelido \n"
                    + "Sem essa informação não podemos continuar.", "Apelido do Usuário",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                nome = JOptionPane.showInputDialog("digite seu nome ou apelido : ");
                aux = true;
            } else {
                aux = false;
            }
        }

        return aux;
    }

    /**
     * Metodo para exibir na tela o ip do computador
     *
     * @return um string contendo o ip do computador
     */
    public String say() {
        String ip = "0.0.0.0  ";
        try {
            java.net.InetAddress i = java.net.InetAddress.getLocalHost();
            ip = i.getHostAddress();
            // System.out.println(ip); // IP address only  

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ip;
    }

    /**
     * Metodo responsavel para verificar qual o tipo de criptografia selecionado
     *
     * @param vlrTpCrypt - qual o tipo de criptografia selecionado
     */
    public void setTpCrypt(int vlrTpCrypt) {
        this.tpCrypt = vlrTpCrypt;
        sys.EscreveLogConsole("ClienteInterface - Metodo setTpCrypt", "Valor de vlrTpCrypt : " + vlrTpCrypt);
        sys.EscreveLogConsole("ClienteInterface - Metodo setTpCrypt", "Valor de this.vlrTpCrypt : " + this.tpCrypt);

    }

    /**
     * Metodo responsavel pela geracao da chave de criptografia
     *
     * @return retorna a chave gerada
     */
    public void AutoLog() {
        /*
         try {
         autolog = new File("LogsCripto\\" + Data + "_autoLog_" + nome + ".logSc");
         sys.CriaLog(autolog);
         System.setErr(new PrintStream(autolog));
         System.setOut(new PrintStream(autolog));            
         } catch (FileNotFoundException ex) {
         Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);
         }
         */

        MessageConsole mc = new MessageConsole(console.jTextArea1);
        mc.redirectOut();
        mc.redirectErr(Color.RED, null);
        console.setTitle( nome + " - " + console.getTitle());
        console.setVisible(true);
        console.setLocationRelativeTo(null);
    }

    private void ValidaCriptoBtnEnviaMsg(String textoDigitado) {
        
        
        
        if (this.message.getTpCrypt() == 0) {

            //Sem Criptografia                
            this.message.setText(textoDigitado);
            sys.EscreveLogConsole("ClienteInterface - Metodo btnEnviarActionPerformed[NoCrypt]", "[" + this.message.getName() + "]" + "textOld : " + textoDigitado);
            sys.EscreveLogConsole("ClienteInterface - Metodo btnEnviarActionPerformed[NoCrypt]", "[" + this.message.getName() + "]" + "txtMSG : " + this.message.getText());

        } else if (this.message.getTpCrypt() == 2) {

            //DES ECB
            sys.EscreveLogConsole("[ClienteInterface - Metodo btnEnviarActionPerformed][ChaveDES-ECB] : ", "[" + this.message.getName() + " : " + Base64.getEncoder().encodeToString(chaveDESECB.getEncoded()));
            sys.EscreveLogConsole("[ClienteInterface - Metodo btnEnviarActionPerformed][ChaveDES-ECB] : ", "[" + this.message.getName() + "]" + "TextoDescriptografado : " + classeDES.CriptoDESPaddingECBDecrypter(txtbyte, chaveDESECB));

            //Criptografia DES ECB                
            txtbyte = criptografarDES(this.message.getTpCrypt(), textoDigitado);
            this.message.setBytetxt(txtbyte);
            this.message.setText("Mensagem Criptografada");

        } else if (this.message.getTpCrypt() == 3) {
            try {
                //DES CBC
                sys.EscreveLogConsole("[ClienteInterface - Metodo btnEnviarActionPerformed][ChaveDES-CBC] : ", "[" + this.message.getName() + "]" + chaveDESCBC);
                //Criptografia DES CBC                
                txtbyte = criptografarDES(this.message.getTpCrypt(), textoDigitado);
                this.message.setBytetxt(txtbyte);
                this.message.setText("Mensagem Criptografada");

            } catch (Exception ex) {
                Logger.getLogger(ClientInterface_v3.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (this.message.getTpCrypt() == 4) {
            try {
                //AES
                sys.EscreveLogConsole("[ClienteInterface - Metodo btnEnviarActionPerformed]", "[AES - 4]");

                txtbyte = criptografiaAES(1,textoDigitado);
                this.message.setText("Mensagem Criptografada");
                sys.EscreveLogConsole("[ClienteInterface - Metodo btnEnviarActionPerformed][AES - 4]", "TextoDescriptografado : " + classeAES.decrypt(txtbyte, chaveAES));
            } catch (Exception ex) {
                Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (this.message.getTpCrypt() == 5) {//AES
            try {
                //AES
                sys.EscreveLogConsole("[ClienteInterface - Metodo btnEnviarActionPerformed]", "[AES - 5]");

                txtbyte = criptografiaAES(2,textoDigitado);
                this.message.setText("Mensagem Criptografada");
                sys.EscreveLogConsole("[ClienteInterface - Metodo btnEnviarActionPerformed][AES - 5]", "TextoDescriptografado : " + classeAES.decrypt(txtbyte, chaveAES));
            } catch (Exception ex) {
                Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (this.message.getTpCrypt() == 6) {//RSA
            this.message.setText("Mensagem Criptografada");
            sys.EscreveLogConsole("[ClienteInterface - Metodo btnEnviarActionPerformed]", "[RSA]");
            txtbyte = criptografiaRSA(1, textoDigitado);
        }
    }

    private class ListenerSocket implements Runnable {

        private ObjectInputStream input;

        public ListenerSocket(Socket socket) {
            try {
                this.input = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void run() {
            ChatMessage message = null;
            try {
                while ((message = (ChatMessage) input.readObject()) != null) {
                    Action action = message.getAction();

                    if (action.equals(Action.CONNECT)) {
                        connected(message);
                    } else if (action.equals(Action.DISCONNECT)) {
                        disconnected();
                        socketTeste.close();
                    } else if (action.equals(Action.SEND_ONE)) {
                        //System.out.println("::: " + message.getText() + " :::");
                        receive(message);
                    } else if (action.equals(Action.USERS_ONLINE)) {
                        refreshOnlines(message);
                    }
                }
            } catch (IOException ex) {
                sys.EscreveLogConsole("ClienteInterface - Metodo Run[ClassNotFoundException]", "Erro : " + ex.getMessage());

            } catch (ClassNotFoundException ex) {
                sys.EscreveLogConsole("ClienteInterface - Metodo Run[ClassNotFoundException]", "Erro : " + ex.getMessage());

            }
        }

    }

    /**
     * Metodo para conectar o cliente no servidor
     *
     * @param message
     */
    private void connected(ChatMessage message) {

        sys.EscreveLogConsole("ClienteInterface - Metodo Connected", "***Inicio****");

        if (message.getText().equals("NO")) {

            sys.EscreveLogConsole("ClienteInterface - Metodo Connected", "[" + this.message.getName() + "]" + "Dentro do if");
            sys.EscreveLogConsole("ClienteInterface - Metodo Connected", "[" + this.message.getName() + "]" + "Conexão não realizada!\nTente novamente com um novo nome.");
            JOptionPane.showMessageDialog(this, "Conexão não realizada!\nTente novamente com um novo nome.");
            return;

        }
        if ((message.getTpCrypt() == 2)
                || (message.getTpCrypt() == 3)) {
            //if (!message.isIsGenaratedKey()) {
            //chaveDES = geraChaveDES();
            //message.setIsGenaratedKey(true);

            sys.EscreveLogConsole("ClienteInterface - Metodo Connected", "[" + this.message.getName() + "]" + "Chave DES gerada : " + message.getChaveDES());

            //System.out.println(chaveDES.toString());
            //sys.EscreveLogConsole("ClienteInterface - Metodo Connected", "[" + this.message.getName() + "]" + "Chave DES gerada : " +  Base64.getEncoder().encodeToString(chaveDES.getEncoded()));
            sys.EscreveLogConsole("ClienteInterface - Metodo Connected", "[" + this.message.getName() + "]" + "isIsGenaratedKey : " + message.isIsGenaratedKey());

            //message.setChaveDES(chaveDES);
            //}
        } else if (this.message.getTpCrypt() == 4) {//AES

        } else if (this.message.getTpCrypt() == 5) {//AES

        } else if (this.message.getTpCrypt() == 6) {//RSA

        }

        this.listOnlines.setEnabled(true);
        String a = new String().valueOf(message.getTpCrypt());
        sys.EscreveLogConsole("ClienteInterface - Metodo Connected", "[" + this.message.getName() + "]" + "[TpCrypt] " + a);

        this.message = message;

        a = new String().valueOf(this.message.getTpCrypt());
        sys.EscreveLogConsole("ClienteInterface - Metodo Connected", "[" + this.message.getName() + "]" + "[TpCrypt] " + a);

        this.btnConnectar.setEnabled(false);
        this.MenuOpcoes.setEnabled(false);

        this.btnSair.setEnabled(true);
        this.txtAreaSend.setEnabled(true);
        this.txtAreaReceive.setEnabled(true);
        this.btnEnviar.setEnabled(true);
        this.btnLimpar.setEnabled(true);

        this.StatusLabel.setText("Conectado");

        //Inseri essa linha e a descriptografia começou a funcionar normalmente.
        if (message.getTpCrypt() == 2) {
            chaveDESECB = this.message.getChaveDES();
            sys.EscreveLogConsole("ClienteInterface - Metodo Connected", "[Chave DES] : " + chaveDESECB);
        } else if (message.getTpCrypt() == 3) {
            chaveDESCBC = this.message.getChaveDESCBC();
            sys.EscreveLogConsole("ClienteInterface - Metodo Connected", "[Chave DES-CBC] : " + chaveDESCBC);
        } else if (this.message.getTpCrypt() == 4) {//AES

        } else if (this.message.getTpCrypt() == 5) {//AES

        } else if (this.message.getTpCrypt() == 6) {//RSA

        }
        //************************************************
        JOptionPane.showMessageDialog(this, "Você está conectado no chat!");
        sys.EscreveLogConsole("ClienteInterface - Metodo Connected", "[" + this.message.getName() + "]" + "Você está conectado no chat!");
        sys.EscreveLogConsole("ClienteInterface - Metodo Connected", "***FIM****");

        isConected = true;
    }

    /**
     * Metodo responsável para desconectar o cliente do servidor
     */
    private void disconnected() {

        byte[] varAuxDIS = null;
        String ChaveAES = null;
        isConected = false;
        //*********Metodo Desconectar
        //ChatMessage message = new ChatMessage();
        message.setName(this.message.getName());

        this.message.setAction(Action.DISCONNECT);

        if (this.message.getTpCrypt() == 1) {

            String aux = this.message.getText();

            sys.EscreveLogConsole("ClienteInterface - Metodo Disconnected[AES]", "***Inicio****");
            sys.EscreveLogConsole("ClienteInterface - Metodo Disconnected[AES]", "[" + this.message.getName() + "]" + "Texto : " + aux);

            //AES
            varAuxDIS = this.message.getBytetxt();
            try {
                sys.EscreveLogConsole("ClienteInterface - Metodo Disconnected[AES]", "[" + this.message.getName() + "]" + "Texto Descriptografado : " + classeAES.decrypt(varAuxDIS, ChaveAES));
            } catch (Exception ex) {
                sys.EscreveLogConsole("ClienteInterface - Metodo Disconnected[AES]", "Erro AES : " + ex.getMessage());

            }

            //Rot47
            //sys.EscreveLogConsole("ClienteInterface - Metodo Disconnected[ROT47]",  "[" + this.message.getName()+ "]" + "Texto Descriptografado : " + rot.Decrypt(aux));
            sys.EscreveLogConsole("ClienteInterface - Metodo Disconnected[AES]", "[" + this.message.getName() + "]" + "***FIM***");

        } else if ((this.message.getTpCrypt() == 2) || (this.message.getTpCrypt() == 3)) {

            varAuxDIS = this.message.getBytetxt();
            sys.EscreveLogConsole("ClienteInterface - Metodo Disconnected[DES]", "***Inicio****");
            sys.EscreveLogConsole("ClienteInterface - Metodo Disconnected[DES]", "[" + this.message.getName() + "]" + "Texto Em Bytes: " + varAuxDIS);
            /*---->>>*/
            if (this.message.getTpCrypt() == 2) {
                /*---->>>*/ sys.EscreveLogConsole("ClienteInterface - Metodo Disconnected[DES]", "[" + this.message.getName() + "]" + "Texto Descriptografado : " + classeDES.CriptoDESPaddingECBDecrypter(txtbyte, chaveDESECB));
                /*---->>>*/ sys.EscreveLogConsole("ClienteInterface - Metodo Disconnected[DES]", "[" + this.message.getName() + "]" + "***FIM***");
                /*---->>>*/ } else if (this.message.getTpCrypt() == 3) {
                try {
                    /*---->>>*/     //DES CBC
/*---->>>*/ sys.EscreveLogConsole("ClienteInterface - Metodo Disconnected[DES]", "[" + this.message.getName() + "]" + "Texto Descriptografado : " + classeDES.decryptCBC(txtbyte, "password"));
                    /*---->>>*/ sys.EscreveLogConsole("ClienteInterface - Metodo Disconnected[DES]", "[" + this.message.getName() + "]" + "***FIM***");
                    /*---->>>*/                } catch (Exception ex) {
                    /*---->>>*/ Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);
                    /*---->>>*/                }
                /*---->>>*/ }

        } else if (this.message.getTpCrypt() == 4) {//AES

        } else if (this.message.getTpCrypt() == 5) {//AES

        } else if (this.message.getTpCrypt() == 6) {//RSA

        }

        this.service.send(this.message);
        this.btnConnectar.setEnabled(true);
        //this.MenuDesconcetar.setEnabled(false);
        this.listOnlines.setEnabled(false);
        this.listOnlines.setListData(new Vector());

        this.txtAreaSend.setText(null);
        this.txtAreaReceive.setText(null);
        this.btnSair.setEnabled(false);
        this.MenuOpcoes.setEnabled(false);
        this.txtAreaSend.setEnabled(false);
        this.txtAreaReceive.setEnabled(false);
        this.btnEnviar.setEnabled(false);
        this.btnLimpar.setEnabled(false);
        this.setTitle("Você está Offline ");
        this.StatusLabel.setText("Desconectado");

    }

    /**
     * Metodo responsavel pelo recebimento das mensagens
     *
     * @param message
     */
    private void receive(ChatMessage message) {
        sys.EscreveLogConsole("ClienteInterface - Metodo receive", "****INICIO***");

        String a = null;
        //message.setTpCrypt(2);
        a = new String().valueOf(message.getTpCrypt());
        sys.EscreveLogConsole("ClienteInterface - Metodo receive", message.toString());
        sys.EscreveLogConsole("ClienteInterface - Metodo receive", "[" + this.message.getName() + "]" + "[TpCrypt] " + a);

        ExibeMsg(message.getTpCrypt());

        sys.EscreveLogConsole("ClienteInterface - Metodo receive", "****FIM***");
    }

    /**
     * Metodo responsavel para a atualizar a lista de usuarios onlines
     *
     * @param message
     */
    private void refreshOnlines(ChatMessage message) {
        sys.EscreveLogConsole("ClienteInterface - Metodo refreshOnlines", "***INICIO***");
        sys.EscreveLogConsole("ClienteInterface - Metodo refreshOnlines", "Usuario : " + message.getName());
        sys.EscreveLogConsole("ClienteInterface - Metodo refreshOnlines", "Usuarios : " + message.getSetOnlines().toString());

        Set<String> names = message.getSetOnlines();

        String[] array = (String[]) names.toArray(new String[names.size()]);

        this.listOnlines.setListData(array);
        this.listOnlines.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.listOnlines.setLayoutOrientation(JList.VERTICAL);
        sys.EscreveLogConsole("ClienteInterface - Metodo refreshOnlines", "***FIM***");
    }

    /**
     * Metodo para criptografar a mensagem do usuário
     *
     * @param i tipo de criptografia selecionado pelo usuário
     * @param txt texto a ser criptografado
     * @return
     */
    private byte[] criptografarDES(int i, String txt) {
        byte[] aux = null;
        sys.EscreveLogConsole("ClienteInterface - Metodo criptografar", " Texto : " + txt);

        //DES
        sys.EscreveLogConsole("ClienteInterface - Metodo criptografar[DES]", "[" + this.message.getName() + "]" + "Texto Claro : " + txt);
        if (i == 2) {
            sys.EscreveLogConsole("ClienteInterface - Metodo criptografar[DES]", "[" + this.message.getName() + "]" + "ChavesDES : " + Base64.getEncoder().encodeToString(chaveDESECB.getEncoded()));

            //Momento que ocorre a encriptação do texto com base na chave DES gerada.            
/*---->>>*/ aux = classeDES.CriptoDESPaddingECB(txt, chaveDESECB);
        } else if (i == 3) {
            sys.EscreveLogConsole("ClienteInterface - Metodo criptografar[DES]", "[" + this.message.getName() + "]" + "ChavesDES-CBC : " + Base64.getEncoder().encodeToString(chaveDESCBC.getEncoded()));
            try {
                aux = classeDES.encryptCBC(txt, chaveDESCBC.toString());
            } catch (Exception ex) {
                Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        sys.EscreveLogConsole("ClienteInterface - Metodo criptografar[DES]", " aux : " + aux);

        return aux;
    }

    private byte[] criptografiaAES(int a,String txt) {
        byte[] auxAES = null;
        try {
            auxAES = classeAES.encrypt(txt, chaveAES);
        } catch (Exception ex) {
            sys.EscreveLogConsole("ClienteInterface - Metodo Disconnected[AES]", "Erro AES : " + ex.getMessage());
        }

        return auxAES;
    }
    
    private byte[] criptografiaRSA(int a,String msg){
        byte[] auxRSA = null;
        byte[] descriptografadoRSA = null;
        String textoLimpo = "";
        sys.EscreveLogConsole("[ClienteInterface - Metodo criptografiaRSA]","*************************************************************");
        sys.EscreveLogConsole("[ClienteInterface - Metodo criptografiaRSA]","msg : " + msg);
        sys.EscreveLogConsole("[ClienteInterface - Metodo criptografiaRSA]","getChavePublicaRSA : " + this.message.getChavePublicaRSA());
        sys.EscreveLogConsole("[ClienteInterface - Metodo criptografiaRSA]","getChavePrivadaRSA : " + this.message.getChavePrivadaRSA());
        sys.EscreveLogConsole("[ClienteInterface - Metodo criptografiaRSA]","*************************************************************");
        auxRSA = classeRSA.encryptRSA(this.message.getChavePublicaRSA(), msg.getBytes());
        descriptografadoRSA = classeRSA.decryptRSA(this.message.getChavePrivadaRSA(), auxRSA);
        sys.EscreveLogConsole("[ClienteInterface - Metodo criptografiaRSA]","Decifrado : " + classeRSA.bytesToString(descriptografadoRSA));
        return auxRSA;
    }

    private void ExibeMsg(int TipoCriptografia) {

        DataMSG = new SimpleDateFormat("[HH:mm:ss]").format(new Date(System.currentTimeMillis()));
        String resultado = "";
        byte[] resultadoRSA = null;
        if (TipoCriptografia == 0) {

            //Sem Criptografia        
            this.txtAreaReceive.append(DataMSG + message.getName() + " diz : " + message.getText() + "\n");
            sys.EscreveLogConsole("ClienteInterface - Metodo ExibeMsg[noCrypt]", "[" + message.getName() + "]" + message.getText());

        } else if (TipoCriptografia == 2) {

            //Criptografia DES  
            //DES ECB
            resultado = classeDES.CriptoDESPaddingECBDecrypter(message.getBytetxt(), chaveDESECB);//Descriptografa a mensagem

            this.txtAreaReceive.append(DataMSG + message.getName() + " diz : " + resultado + "\n");
            sys.EscreveLogConsole("ClienteInterface - Metodo ExibeMsg[DES]", "Resultado : " + resultado);
            sys.EscreveLogConsole("ClienteInterface - Metodo ExibeMsg[DES]", "Resultado[toString] : " + resultado.toString());
            //sys.EscreveLogConsole("ClienteInterface - Metodo ExibeMsg[DES]", "Teste[DES] : " +classeDES.descriptar(message.getBytetxt()));
        } else if (TipoCriptografia == 3) {
            try {
                //DES CBC
                resultado = "";
                resultado = classeDES.decryptCBC(message.getBytetxt(), chaveDESCBC.toString());
                this.txtAreaReceive.append(DataMSG + message.getName() + " diz : " + resultado + "\n");
            } catch (Exception ex) {
                System.out.println(Data + "[ClienteInterface - Metodo ExibeMsg][Exception][DES CBC]descriptar : " + ex.getMessage());
                sys.EscreveLogConsole("ClienteInterface - Metodo ExibeMsg", "[Exception][DES CBC]descriptar : " + ex.getMessage());
            }

        } else if (this.message.getTpCrypt() == 4) {
            try {
                //AES
                resultado = classeAES.decrypt(message.getBytetxt(), chaveAES);
                this.txtAreaReceive.append(DataMSG + message.getName() + " diz : " + resultado + "\n");
            } catch (Exception ex) {
                System.out.println(Data + "[ClienteInterface - Metodo ExibeMsg][Exception][AES]descriptar : " + ex.getMessage());
                sys.EscreveLogConsole("ClienteInterface - Metodo ExibeMsg", "[Exception][AES]descriptar : " + ex.getMessage());
            }
        } else if (this.message.getTpCrypt() == 5) {//AES
            try {
                //AES
                resultado = classeAES.decrypt(message.getBytetxt(), chaveAES);
                this.txtAreaReceive.append(DataMSG + message.getName() + " diz : " + resultado + "\n");
            } catch (Exception ex) {
                System.out.println(Data + "[ClienteInterface - Metodo ExibeMsg][Exception][AES]descriptar : " + ex.getMessage());
                sys.EscreveLogConsole("ClienteInterface - Metodo ExibeMsg", "[Exception][AES]descriptar : " + ex.getMessage());
            }
        } else if (this.message.getTpCrypt() == 6) {//RSA
              sys.EscreveLogConsole("ClienteInterface - Metodo ExibeMsg[RSA]","");  
              resultadoRSA = classeRSA.decryptRSA(ChatMessage.getChavePrivadaRSA(), message.getBytetxt());
              this.txtAreaReceive.append(DataMSG + message.getName() + " diz : " + resultado + "\n");
        }
    }

  
    
    
}