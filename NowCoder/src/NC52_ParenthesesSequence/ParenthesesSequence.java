package NC52_ParenthesesSequence;

import org.junit.Test;

public class ParenthesesSequence {
    @Test
    public void test001() {
        assert !new Solution().isValid("[");
    }

    @Test
    public void test002() {
        assert new Solution().isValid("[]");
    }
}
