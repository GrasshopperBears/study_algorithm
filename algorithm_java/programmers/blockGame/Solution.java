package programmers.blockGame;

import java.util.HashSet;

class RelPos {
    int r, c;

    public RelPos(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Block {
    boolean isPossible;
    RelPos[] relPos;
    int[] hide;

    public Block(boolean isPossible, int[] hide, RelPos[] relPos) {
        this.isPossible = isPossible;
        this.hide = hide;
        this.relPos = relPos;
    }
}

class Solution {
    private int n;
    private int[][] board;
    private Block[] blocks = new Block[12];
    private boolean[] hidden;

    private void init() {
        int[] hiderr = new int[] { 1, 2 };
        int[] hidelr = new int[] { -1, 1 };
        int[] hidell = new int[] { -2, -1 };
        int[] hider = new int[] { 1 };
        int[] hidel = new int[] { -1 };

        RelPos r = new RelPos(0, 1);
        RelPos rr = new RelPos(0, 2);
        RelPos d = new RelPos(1, 0);
        RelPos dd = new RelPos(2, 0);
        RelPos dr = new RelPos(1, 1);
        RelPos drr = new RelPos(1, 2);
        RelPos ddl = new RelPos(2, -1);
        RelPos ddr = new RelPos(2, 1);
        RelPos dl = new RelPos(1, -1);
        RelPos dll = new RelPos(1, -2);

        blocks[0] = new Block(false, hiderr, new RelPos[] { r, rr, drr });
        blocks[1] = new Block(false, hider, new RelPos[] { r, d, dd });
        blocks[2] = new Block(true, hiderr, new RelPos[] { d, dr, drr });
        blocks[3] = new Block(true, hidel, new RelPos[] { d, dd, ddl });

        blocks[4] = new Block(false, hiderr, new RelPos[] { r, rr, d });
        blocks[5] = new Block(true, hider, new RelPos[] { d, dd, ddr });
        blocks[6] = new Block(true, hidell, new RelPos[] { d, dl, dll });
        blocks[7] = new Block(false, hider, new RelPos[] { r, dr, ddr });

        blocks[8] = new Block(true, hidelr, new RelPos[] { d, dl, dr });
        blocks[9] = new Block(false, hider, new RelPos[] { d, dd, dr });
        blocks[10] = new Block(false, hiderr, new RelPos[] { r, rr, dr });
        blocks[11] = new Block(false, hidel, new RelPos[] { d, dd, dl });
    }

    private Block findBlock(int r, int c) {
        int base = board[r][c];
        for (int i = 0; i < blocks.length; i++) {
            boolean found = true;
            Block block = blocks[i];

            for (int j = 0; j < 3; j++) {
                int targetR = r + block.relPos[j].r;
                int targetC = c + block.relPos[j].c;
                if (targetR < 0 || targetC < 0 || targetR >= n || targetC >= n || board[targetR][targetC] != base) {
                    found = false;
                    break;
                }
            }
            if (found)
                return block;
        }
        return null;
    }

    private boolean checkHidden(int c, int[] hide) {
        for (int i : hide) {
            if (hidden[c + i])
                return false;
        }
        return true;
    }

    private void setHidden(int c, int[] hide) {
        hidden[c] = true;
        for (int i : hide)
            hidden[c + i] = true;
    }

    private boolean isRemovable(int r, int c) {
        Block block = findBlock(r, c);
        if (block.isPossible && checkHidden(c, block.hide))
            return true;
        setHidden(c, block.hide);
        return false;
    }

    public int solution(int[][] board) {
        int answer = 0;
        HashSet<Integer> visited = new HashSet<>();

        this.board = board;
        n = board.length;
        hidden = new boolean[n];

        init();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int block = board[i][j];
                if (board[i][j] > 0 && !visited.contains(block)) {
                    visited.add(block);
                    if (isRemovable(i, j))
                        answer++;
                }
            }
        }
        return answer;
    }
}
