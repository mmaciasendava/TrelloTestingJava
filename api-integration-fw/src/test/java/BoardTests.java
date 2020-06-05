import org.mmaciasendava.board.BoardApi;
import org.mmaciasendava.models.Board;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.net.URISyntaxException;
import java.util.List;

public class BoardTests extends  BaseTest {

    @Test
    public void aBoardExistInListBoards() throws URISyntaxException {
        BoardApi boards = new BoardApi();
        List<Board> boardList = boards.getBoards();
        assertThat(boardList, hasSize(greaterThan(0)));
    }

    @Test
    public void anIdAndUrlAreAssignedToNewBoardCreatedByTitle() throws URISyntaxException {
        BoardApi boardApi = new BoardApi();
        Board boardRequest = new Board();
        boardRequest.setName("Test Automated");
        Board boardResponse = boardApi.createBoard(boardRequest);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(boardResponse.getName(), boardRequest.getName());
        softAssert.assertNotNull(boardResponse.getId());
        softAssert.assertNotNull(boardResponse.getUrl());
        softAssert.assertAll();
        boardApi.deleteBoard(boardResponse.getId());
    }
}

