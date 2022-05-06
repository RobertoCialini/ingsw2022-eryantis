package it.polimi.ingsw.model;

import it.polimi.ingsw.listener.PropertyObserver;
import it.polimi.ingsw.model.calculations.influence.InfluenceManager;
import it.polimi.ingsw.model.calculations.professor.ProfessorManager;
import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.PlayerPhase;
import it.polimi.ingsw.model.enumerations.Wizard;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandManager;
import it.polimi.ingsw.model.objectTypes.FixedObjectStudent;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.rounds.*;
import it.polimi.ingsw.model.studentSuppliers.Bag;
import it.polimi.ingsw.model.studentSuppliers.Cloud;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 */
public class Game implements GameInterface, Serializable {

    /**
     * Built already the instance of the Rounds
     */
    public Game() {
        this.ingressHallSwap=new IngressHallSwapActionRound(this);
        this.studentToIslandRound=new StudentToIslandActionRound(this);
        this.ingressCardSwap=new IngressCardSwapActionRound((this));
        this.studentToHallRound= new StudentToHallActionRound(this);
        this.setUpRound= new SetUpRound(this);
        setRound(this.setSetUpRound());


    }
    /**
     * Keep the reference to the observer
     */
    private PropertyObserver observer;
    /**
     *
     */
    private PropertyChangeSupport propertyChange= new PropertyChangeSupport(this);

    /**
     *Kepp the reference to ingressCArdSwap
     */
    private RoundInterface ingressCardSwap;

    /**
     *Keep the reference to ingressHallSwap
     */
    private RoundInterface ingressHallSwap;

    /**
     *Keep the reference to actionRound
     */
    private RoundInterface actionRound;

    /**
     *Keep the reference to pianificationRound
     */
    private RoundInterface pianificationRound;

    /**
     *Keep the reference to studentToIslandRound
     */
    private RoundInterface studentToIslandRound;

    /**
     *Keep the reference to studentToHallRound
     */
    private RoundInterface studentToHallRound;

    /**
     *Keep the reference to studentToHallRound
     */
    private RoundInterface setUpRound;

    /**
     *
     */
    private LinkedList<Cloud> clouds=new LinkedList<>();

    /**
     *Keep track of the order in every  round, dinamically change itself, collect the first who became the current player and at the end of his turn gets removed from the list, start a new pianification round when the list is empty
     */
    private LinkedList <Player> orderedPLayerList= new LinkedList<>();

    /**
     *This list contains the order set for all the game, its needed for play assistant card
     */
    private LinkedList <Player> playerList = new LinkedList<>();

    /**
     *
     */
    private MotherNature motherNature=new MotherNature();

    /**
     *Keep track of the round which is currently on
     */
    private RoundInterface currentRound;

    /**
     *Keep the track of the round which is called before
     */
    private RoundInterface previousRound;

    /**
     *
     */
    private Boolean isThree = false;

    /**
     *
     */
    private Bag bag = new Bag(isThree);


    /**
     *
     */
    private InfluenceManager influenceManager=new InfluenceManager(motherNature, playerList);


    /**
     *
     */
    private IslandManager islandManager=new IslandManager(motherNature);

    /**
     *
     */
    private ProfessorManager professorManager=new ProfessorManager(playerList);

    /**
     *
     */
    private CardManager cardManager=new CardManager(influenceManager,islandManager,professorManager, playerList,bag);

    /**
     *
     */
    private Boolean isStarted;

    /**
     *Keep track of the current player
     */
    private Player currentPlayer=new Player("ciao");

    /**
     *
     */
    private void restoreGame() {
        // TODO implement here
    }

    /**
     * @param pc1
     */
    public void addListener(PropertyChangeListener pc1){
        propertyChange.addPropertyChangeListener(pc1);
    }

    /**
     *
     */
    public void setIsThree() { isThree = true; }

    /**
     *
     */
    public void inizializeGame() {
        for(int i = 0; i< playerList.size(); i++) {
            Cloud cloud=new Cloud();
            this.clouds.add(cloud);
            for(int j=0;(isThree && j<4) || (!isThree && j<3);j++)
                this.clouds.get(i).addStudent(this.bag.newStudent());
        }


        // generate random numbers within 1 to 12

            int rand = (int)(Math.random() * 12) ;

        this.motherNature.setIsland(islandManager.getIslands().get(rand));
        Island island= (Island) this.islandManager.nextIsland(6);

        for(int i =0;i<11;i++) {
            if (!(islandManager.getIslands().get(i) == this.motherNature.getIsland()) || !(islandManager.getIslands().get(i)==island)) {
                Island island1 = (Island) islandManager.getIslands().get(i);
                island1.addStudent(this.bag.newStudent());
                }
            }
        for(int i = 0; i< playerList.size(); i++) {
            playerList.get(0).setPlayerPhase(PlayerPhase.SET_UP_PHASE);
            for (int j = 0; (isThree && j<9) || (!isThree && j<7); j++){

                //playerList.get(i).getSchool().getIngress().addStudent(this.bag.newStudent());

        }
        }
            this.currentPlayer=playerList.getFirst();
    }

    /**
     * @param round     Set the current round
     */
    public void setRound(RoundInterface round) {
       this.currentRound=round;
    }

    /**
     * @param round     Set the previous round
     */
    public void setPreviousRound(RoundInterface round) {
        this.previousRound=round;

    }

    /**
     *
     * @return previousRound    Return the previous round
     */
    public RoundInterface getPreviousRound() {
        return this.previousRound;
    }


    /**
     * @param players playerList        Set the playerList
     */
    public void setPLayerList(LinkedList<Player> players) {
        this.playerList =players;
    }

    /**
     * @return
     */
    private Player endGame() {
        // TODO implement here
        return null;
    }

    public RoundInterface getCurrentRound(){
        return this.currentRound;
    }

    /**
     * @param first     Set the current player
     */
    public void setCurrentPlayer(Player first) {
        this.currentPlayer=first;
    }

    /**
     * @param name
     * @param playerNum
     */
    public void playerLogin(String name, Integer playerNum) {
        // TODO implement here
    }

    /**
     * @param playerNum
     */
    @Override
    public void startGame(LinkedList<Player> playerNum) {

    }

    /**
     * @param playerNum
     */
    public void startGame(Integer playerNum) {
        // TODO implement here
    }

    /**
     *
     */
    public void saveGame() {
        // TODO implement here
    }

    /**
     * @return
     */
    public Boolean isStarted() {
        // TODO implement here
        return null;
    }

    /**
     * @param student       Move the student from the ingress to the hall
     */
    public void moveStudentIngressToHall(Student student) {
        if(!this.currentRound.moveStudentIngressToHall(student))
            System.out.println("Move not possible");
        if(this.currentRound.moveStudentIngressToHall(student))
            this.currentPlayer.getSchool().getHall().getLine(student.getColor()).addStudent(student);
        propertyChange.firePropertyChange("moveStudentIngress",  this.currentPlayer.getSchool().getHall().getLine(student.getColor()),student);
    }

    /**
     * @param student       Student in the ingress
     * @param island        Island where we want to move>>
     */
    public void moveStudentIngressToIsland(Student student, Island island) {
        if (!this.currentRound.moveStudentIngressToIsland(student,island))
            System.out.println("Move not possible");
        if(this.currentRound.moveStudentIngressToIsland(student,island))
            island.addStudent(student);
        propertyChange.firePropertyChange("moveStudentToIsland",island,student);
    }

    /**
     * @param jumps
     */
    public void moveMotherNature(Integer jumps) {
        if(this.currentRound.moveMotherNature(jumps))
            this.motherNature.setIsland(this.islandManager.nextIsland(jumps));
        if(!this.currentRound.moveMotherNature(jumps))
            System.out.println("Move not possible");
        propertyChange.firePropertyChange("mmove mothernature",jumps,motherNature.getIsland());

    }

    /**
     * @param assistantCard     Play playAssistantCard on the currentRound
     */
    @Override
    public void playAssistantCard(AssistantCard assistantCard) {
        this.currentPlayer.setPlayerPhase(PlayerPhase.CHOOSING_ASSISTANT);
        if(!this.currentRound.playAssistantCard(assistantCard,this.currentPlayer))
            System.out.println("Card already played");
        propertyChange.firePropertyChange("Play assistant card",null,assistantCard);

    }


    /**
     * @param expertCard        Play the expert card
     */
    public Boolean playExpertCard(ExpertCard expertCard) {
        //Manca l'observer
        return this.currentRound.playExpertCard(expertCard, null);
    }

    /**
     * @param student               The student we want to put on the island
     * @param island                The island where we want to put hte student
     */
    public void expertStudentToIsland(Student student, Island island) {
        if(this.currentRound.expertStudentToIsland(student,island)){
            island.addStudent(student);
            FixedObjectStudent expertCard= (FixedObjectStudent) cardManager.getCurrentCard();
            expertCard.addStudent(this.bag.newStudent());
            cardManager.setCurrentCard(null); //questa mossa si può fare una sola volta
            propertyChange.firePropertyChange("expert moveStudentToIsland",island,student);

        }
    }

    /**
     * @param studentCard           The studentCard from the ExpertCard
     * @param studentIngress        The student from the ingress
     */
    public void expertIngressCardSwap(Student studentCard, Student studentIngress) {
        if(this.currentRound.expertIngressCardSwap(studentCard, studentIngress)) {
            this.currentPlayer.getSchool().getIngress().addStudent(studentCard);
            FixedObjectStudent expertCard= (FixedObjectStudent) cardManager.getCurrentCard();
            expertCard.addStudent(studentCard);
            propertyChange.firePropertyChange("expert moveStudentToIsland",studentCard,studentIngress);
        }

    }

    /**
     * @param studentHall           The student present in the hall
     * @param studentIngress        The student present on the ingress
     */
    public void expertIngressHallSwap(Student studentHall, Student studentIngress) {
        if(this.currentRound.expertIngressHallSwap(studentHall,studentIngress)) {
            currentPlayer.getSchool().getIngress().addStudent((studentHall));
            currentPlayer.getSchool().getHall().getLine(studentIngress.getColor()).addStudent(studentIngress);
            propertyChange.firePropertyChange("expert IngressHallSwap",studentHall,studentIngress);
        }

    }

    /**
     * @param student           The student we want to put in the Hall
     */
    public void expertStudentToHall(Student student) {
        if(this.currentRound.expertStudentToHall(student)) {
            currentPlayer.getSchool().getHall().addStudent(student);
            FixedObjectStudent expertCard= (FixedObjectStudent) cardManager.getCurrentCard();
            expertCard.addStudent(this.bag.newStudent());
            cardManager.setCurrentCard(null); //questa mossa si può fare una sola volta
            propertyChange.firePropertyChange("expert moveStudentToHall",this.currentPlayer.getSchool().getHall(),student);
        }
    }

    /**
     * @param cloud         The cloud we want to select
     *                      Its not clear how we set the cloud we can get
     */
    public void chooseCloud(Cloud cloud) {
        if(this.currentRound.chooseCloud(cloud)) {
            while (cloud.getStudents().size() != 0) {
                this.currentPlayer.getSchool().getIngress().addStudent(cloud.getStudents().getLast());
            }
            propertyChange.firePropertyChange("Choose cloud",this.clouds,cloud);
        }
        propertyChange.firePropertyChange("Choose cloud",this.clouds,cloud);
        this.currentRound.checkRoundEnded();
    }




    /**
     * @return
     */
    public Boolean chooseExpertMode() {
        // TODO implement here
        return null;
    }

    /**
     * @return currentPlayer      Return the currentPlayer
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public Boolean chooseColorAndDeck(PlayerColor color, Wizard wizard) {

        if (this.currentRound.chooseColorAndDeck(currentPlayer, color, wizard))
        {
            this.currentPlayer.setPlayerColor(color);
            currentPlayer.setWizard(wizard);
            propertyChange.firePropertyChange("Finished expert move",currentPlayer,color);
            return true;
        }
        if (!this.currentRound.chooseColorAndDeck(currentPlayer, color, wizard))
               return false;
        if(playerList.indexOf(currentPlayer)<playerList.size()-1)
        this.currentPlayer=playerList.get(playerList.indexOf(currentPlayer)+1);
        return null;



    }

    /**
     * @return orderedPlayerList    Return the orderedPlayerList
     */
    public LinkedList<Player> getOrderedPLayerList(){
        return new LinkedList<>(this.orderedPLayerList);
    }

    /**
     * Set the orderedPlayerList
     */
    public void setOrderedPLayerList(LinkedList<Player> playerList){
        this.orderedPLayerList=playerList;
    }


    /**
     *@return ingressHallSwap Return the IngressHallSwap
     */
    public IngressHallSwapActionRound setIngressHallSwapState(){
        return (IngressHallSwapActionRound) this.ingressHallSwap;
    }

    /**
     *@return pianificationRound Return the pianificationRound
     */
    public PianificationRound setPianificationnRoundState(){
        this.pianificationRound=new PianificationRound(this);
        return (PianificationRound) this.pianificationRound;
    }

    /**
     *Return the PlayerList
     */
    public LinkedList<Player> getPlayerList() {
        return this.playerList;
    }

    /**
     **@return actionRound Return the actionRound
     */
    public ActionRound setActionRoundState(Integer students){
        this.actionRound=new ActionRound(this,students);
        return (ActionRound) this.actionRound;
    }

    /**
     **@return studentToIslandRound Return the studentToIslandRound
     */
    public StudentToIslandActionRound setStudentToIslandState(){
        return (StudentToIslandActionRound) this.studentToIslandRound;
    }

    /**
     **@return ingressCardSwap Return the ingressCardSwap
     */
    public IngressCardSwapActionRound setIngressCardSwapActionRound(){
        return (IngressCardSwapActionRound) this.ingressCardSwap;
    }

    /**
     *@return studentToHallRound Return the studentToHallRound
     */
    public StudentToHallActionRound setStudentToHallState(){
       return (StudentToHallActionRound) this.studentToHallRound;
    }

    /**
     *
     * @return  setUpRound      Return the setUpRound
     */
    public SetUpRound setSetUpRound(){
        return (SetUpRound) this.setUpRound;
    }

    /**
     *Used if the player wants to finish the move
     */

    public void finishExpertMove(){
        this.currentRound.finishExpertMove();
        propertyChange.firePropertyChange("Finished expert move",getCardManager().getCurrentCard(),null);


    }

    /**
     * @return     Its needed for the rounds when the pick a student from an expert card they put another one, they need to access to current card
     */
    public CardManager getCardManager(){
        return this.cardManager;
    }

    /**
     * @return  Bag     Return the istance of the Bag
     */
    public Bag getBag(){
        return this.bag;
    }

    /**
     * Set the Playerlist, only for dedubbing so far
     */
    public void setPlayerList(LinkedList<Player> players){
        this.playerList =players;
    }

    /**
     *
     * @return  clouds  A new linked list contenent the clouds
     */
    public LinkedList<Cloud> getClouds(){
        return new LinkedList<>(this.clouds);
    }

    /**
     *
     * @param clouds        Set the clouds
     */
    public void setCloud(LinkedList<Cloud> clouds){
        this.clouds=clouds;

    }

    /**
     * Only for testing so far
     * @return
     */
    public MotherNature getMotherNature() {
        return motherNature;
    }
}