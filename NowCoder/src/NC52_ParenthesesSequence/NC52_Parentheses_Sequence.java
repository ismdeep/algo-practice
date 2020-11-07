package NC52_ParenthesesSequence;

import org.junit.Test;

public class NC52_Parentheses_Sequence {
    @Test
    public void test001() {
        assert !new Solution().isValid("[");
    }

    @Test
    public void test002() {
        assert new Solution().isValid("[]");
    }
}
