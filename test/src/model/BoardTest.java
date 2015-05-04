package src.model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class BoardTest {
    private Board board;
    
    @Before
    public void setUp(){
        board = new Board(null);
    }
    
    @Test
    public void squaresListSizeTest(){
        assertEquals(79, board.getSquaresList().size());
    }
    
    @Test
    public void addingOneSquareTest() {
        Square secondSquare = board.getFirstSquare().getRight();
        assertEquals(board.getFirstSquare(), secondSquare.getLeft());
        assertEquals(board.getFirstSquare().getRight(), secondSquare);
    }
    
    @Test
    public void idsTest(){
        assertEquals(1, board.getFirstSquare().getId());
        assertEquals(8, board.getFirstSquare().getRight().getId());
    }
    
    @Test
    public void circularBoardTest(){
        assertEquals(board.getFirstSquare().getLeft(), board.getLastSquare());
        assertEquals(board.getLastSquare().getRight(), board.getFirstSquare());
    }
    
    @Test
    public void notNullSquaresFromMainSquareTest(){
        assertNotNull(board.getMainSquare().getBlueAxis());
        assertNotNull(board.getMainSquare().getBrownAxis());
        assertNotNull(board.getMainSquare().getGreenAxis());
        assertNotNull(board.getMainSquare().getPurpleAxis());
        assertNotNull(board.getMainSquare().getRedAxis());
        assertNotNull(board.getMainSquare().getYellowAxis());
    }
    
    @Test
    public void squaresFromMainSquareWellLinked(){
        assertEquals(board.getMainSquare(), board.getMainSquare().getBlueAxis().getRight());
        assertEquals(board.getMainSquare(), board.getMainSquare().getBrownAxis().getRight());
        assertEquals(board.getMainSquare(), board.getMainSquare().getGreenAxis().getRight());
        assertEquals(board.getMainSquare(), board.getMainSquare().getPurpleAxis().getRight());
        assertEquals(board.getMainSquare(), board.getMainSquare().getRedAxis().getRight());
        assertEquals(board.getMainSquare(), board.getMainSquare().getYellowAxis().getRight());
    }
    
    @Test
    public void fromAnAxisToRightPassingThroughACheese(){
        assertEquals(3, new Moves(board.getSquareById(1),6).getSquaresToMove().size());
        assertTrue(board.canIMoveTo(1, 6, 7));
        assertTrue(board.canIMoveTo(1, 6, 13));
        assertTrue(board.canIMoveTo(1, 6, 73));
    }

    @Test 
    public void fromSquareThreeMovesTest(){
        assertEquals(3, new Moves(board.getSquareById(3),5).getSquaresToMove().size());
        assertTrue(board.canIMoveTo(3, 5, 0));
        assertTrue(board.canIMoveTo(3, 5, 10));
        assertTrue(board.canIMoveTo(3, 5, 76));
    }
    
    @Test 
    public void fromSquareFourMovesTest(){
        assertEquals(2, new Moves(board.getSquareById(4),1).getSquaresToMove().size());
        assertTrue(board.canIMoveTo(4, 1, 5));
        assertTrue(board.canIMoveTo(4, 1, 3));
    }
    
    @Test 
    public void fromSquareSixMovesTest(){
        assertEquals(6, new Moves(board.getSquareById(6),5).getSquaresToMove().size());
        assertTrue(board.canIMoveTo(6, 5, 18));
        assertTrue(board.canIMoveTo(6, 5, 70));
        assertTrue(board.canIMoveTo(6, 5, 57));
        assertTrue(board.canIMoveTo(6, 5, 44));
        assertTrue(board.canIMoveTo(6, 5, 31));
        assertTrue(board.canIMoveTo(6, 5, 1));
    }
    @Test 
    public void fromMainSquareMovesTest(){
        assertEquals(6, new Moves(board.getSquareById(0),5).getSquaresToMove().size());
        assertTrue(board.canIMoveTo(0, 5, 68));
        assertTrue(board.canIMoveTo(0, 5, 3));
        assertTrue(board.canIMoveTo(0, 5, 16));
        assertTrue(board.canIMoveTo(0, 5, 29));
        assertTrue(board.canIMoveTo(0, 5, 42));
        assertTrue(board.canIMoveTo(0, 5, 55));
    }
    
    @Test 
    public void fromSquareFiveMoveTest(){
        assertEquals(4, new Moves(board.getSquareById(10),5).getSquaresToMove().size());
        assertTrue(board.canIMoveTo(10, 5, 15));
        assertTrue(board.canIMoveTo(10, 5, 21));
        assertTrue(board.canIMoveTo(10, 5, 3));
        assertTrue(board.canIMoveTo(10, 5, 77));
    }
    
    @Test 
    public void fromSquareTenMoveTest(){
        assertEquals(3, new Moves(board.getSquareById(10),4).getSquaresToMove().size());
        assertTrue(board.canIMoveTo(10, 4, 14));
        assertTrue(board.canIMoveTo(10, 4, 2));
        assertTrue(board.canIMoveTo(10, 4, 78));
    }
    
    @Test 
    public void fromSquareSixtyFiveAndTwoStepsMoveTest(){
        assertEquals(3, new Moves(board.getSquareById(65),2).getSquaresToMove().size());
        assertTrue(board.canIMoveTo(65, 2, 73));
        assertTrue(board.canIMoveTo(65, 2, 67));
        assertTrue(board.canIMoveTo(65, 2, 63));
    }
    
    @Test 
    public void fromSquareFiveAndOneStepMoveTest(){
        assertEquals(2, new Moves(board.getSquareById(65),1).getSquaresToMove().size());
        assertTrue(board.canIMoveTo(65, 1, 66));
        assertTrue(board.canIMoveTo(65, 1, 64));
        
        assertEquals(6, new Moves(board.getSquareById(0),5).getSquaresToMove().size());
        assertTrue(board.canIMoveTo(0, 5, 3));
        assertTrue(board.canIMoveTo(0, 5, 16));
        assertTrue(board.canIMoveTo(0, 5, 29));
        assertTrue(board.canIMoveTo(0, 5, 42));
        assertTrue(board.canIMoveTo(0, 5, 55));
        assertTrue(board.canIMoveTo(0, 5, 68));
    }
}