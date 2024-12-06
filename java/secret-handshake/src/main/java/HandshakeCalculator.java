import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> signals = new ArrayList<>();

        int winkMask = 1;
        int doubleBlink = 2;
        int closeYourEyes = 4;
        int jump = 8;
        int reverse = 16;
        if ((number & winkMask) == winkMask){
            signals.add(Signal.WINK);
        }
        if ((number & doubleBlink) == doubleBlink){
            signals.add(Signal.DOUBLE_BLINK);
        }
        if ((number & closeYourEyes) == closeYourEyes){
            signals.add(Signal.CLOSE_YOUR_EYES);
        }
        if ((number & jump) == jump){
            signals.add(Signal.JUMP);
        }
        if ((number & reverse) == reverse){
            signals.sort(Collections.reverseOrder());
        }
        System.out.println(signals);

        return signals;
    }

}
