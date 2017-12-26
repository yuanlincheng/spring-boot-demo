package hello;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/26 12:03
 * description: xxx
 * own: Aratek
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Greeting {
    private  long id;
    private  String content;
}
