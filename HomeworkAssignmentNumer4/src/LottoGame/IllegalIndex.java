package LottoGame;

/**
 * this class throws exception if an illegal index was entered
 * @author משה
 *
 */
public class IllegalIndex extends IllegalArgumentException {
public IllegalIndex() {
super();
}
/**
* @param msg error message to be printed
*/
public IllegalIndex(String msg) {
super(msg);
}
}
