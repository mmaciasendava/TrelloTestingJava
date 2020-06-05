package org.mmaciasendava.board;
import org.mmaciasendava.models.Board;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardApi extends BaseApiBuilder{

    public List<Board> getBoards() throws URISyntaxException {
        return Arrays.asList(get(new URI("members/me/boards")).as(Board[].class));
    }

    public Board createBoard(Board boardBody) throws URISyntaxException {
        return post(new URI("board/"), boardBody).as(Board.class);
    }

    public void deleteBoard(String idBoard) {
        Map<String, String> params = new HashMap();
        params.put("id", idBoard);
        delete("board/{id}", params).then().statusCode(200);
    }
}
