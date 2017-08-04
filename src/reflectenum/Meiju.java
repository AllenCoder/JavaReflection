package reflectenum;

/**
 * Created by Allen on 2017/8/4.
 */
public class Meiju {
    private State state =State.DRIVING;

    public State getState() {
        return state;
    }
    public void setState(State state){
        this.state=state;
    }
}
