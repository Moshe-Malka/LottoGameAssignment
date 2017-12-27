package LottoGame;
/**
 ** this class throws an exception if there are too many numbers entered to a table.
 */

public class TooManyNumbers extends Exception {
public TooManyNumbers() {
super();
}
/**
* @param msg error message to be printed
*/
public TooManyNumbers(String msg) {
super(msg);
}
}