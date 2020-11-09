import Core.Board;
import Core.Code;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class BoardTest {
    Code secretCode;

    @BeforeEach
    void setUp() {
      secretCode = new Code(new byte[]{1, 2, 3, 4});
    }

    @Test
    void testBoard() {
        Board board = new Board(secretCode, (byte) 1);
        Assertions.assertTrue(true);
    }

    @Test
    void it_should_throw_RuntimeException_when_board_is_invalid() {
        Assertions.assertThrows(RuntimeException.class,() -> new Board(null, (byte) 1));
        Assertions.assertThrows(RuntimeException.class,() -> new Board(secretCode, (byte) 0));
        Assertions.assertThrows(RuntimeException.class,() -> new Board(secretCode, (byte) -1));
        Assertions.assertThrows(RuntimeException.class,() -> new Board(secretCode, (byte) 200));
    }
}