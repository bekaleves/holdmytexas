package writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import cards.Card;
import evaluation.HandsPowerRank;

public class CsvWriter {

    public static void writeCsv(List<Card> hand, List<Card> desk, HandsPowerRank rank, String path, long millisec) {

        String separator = ",";
        StringBuilder sb = new StringBuilder();
        for (Card c : hand) {
            sb.append(c).append(separator);
        }
        for (int i = 0; i < 5; i++) {
            if (i < desk.size()) {
                Card c = desk.get(i);
                sb.append(c);
            }
            sb.append(separator);
        }
        sb.append(rank.name()).append(separator).append(millisec).append("\n");
        FileWriter write = null;
        BufferedWriter bw = null;
        try {
            write = new FileWriter(new File(path).getAbsoluteFile(), true);
            bw = new BufferedWriter(write);
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
		try { if (write != null) write.close(); }
		finally { if (bw != null) bw.close(); }
	}

    }

}
