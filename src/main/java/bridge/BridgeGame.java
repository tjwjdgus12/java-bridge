package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private int turn = 0;
    private boolean dead = false;

    public BridgeGame (int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public void move(String direction) {
        turn++;
        if (!direction.equals(bridge.get(turn))) {
            dead = true;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        turn = 0;
        dead = false;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getTurn() {
        return turn;
    }

    public boolean isDead() {
        return dead;
    }
}
