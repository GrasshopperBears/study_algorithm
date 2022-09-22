package programmers.collectingStickers2;

public class Solution {
    public int solution(int sticker[]) {
        int stickerNum = sticker.length;
        if (stickerNum == 1)
            return sticker[0];
        if (stickerNum == 2)
            return Math.max(sticker[0], sticker[1]);

        int[][] dpPickFirst = new int[stickerNum - 1][2]; // 0: 안뽑음, 1: 뽑음
        int[][] dpNotPickFirst = new int[stickerNum - 1][2];

        dpPickFirst[0][1] = sticker[0];
        for (int i = 1; i < stickerNum - 1; i++) {
            dpPickFirst[i][0] = Math.max(dpPickFirst[i - 1][0], dpPickFirst[i - 1][1]);
            dpPickFirst[i][1] = dpPickFirst[i - 1][0] + sticker[i];
        }

        dpNotPickFirst[0][1] = sticker[1];
        for (int i = 1; i < stickerNum - 1; i++) {
            dpNotPickFirst[i][0] = Math.max(dpNotPickFirst[i - 1][0], dpNotPickFirst[i - 1][1]);
            dpNotPickFirst[i][1] = dpNotPickFirst[i - 1][0] + sticker[i + 1];
        }

        return Math.max(
                Math.max(dpPickFirst[stickerNum - 2][0], dpPickFirst[stickerNum - 2][1]),
                Math.max(dpNotPickFirst[stickerNum - 2][0], dpNotPickFirst[stickerNum - 2][1]));
    }
}
