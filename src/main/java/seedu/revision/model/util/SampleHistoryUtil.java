package seedu.revision.model.util;

import seedu.revision.model.History;
import seedu.revision.model.ReadOnlyHistory;
import seedu.revision.model.quiz.Statistics;

/**
 * Contains utility methods for populating {@code History} with sample data.
 */
public class SampleHistoryUtil {
    public static Statistics[] getSampleStatistics() {
        return new Statistics[] {
            new Statistics("total = 13/19 , difficulty 1 = 7/7 , difficulty 2 = 5/5 , difficulty 3 = 1/7 , "),
            new Statistics("total = 10/19 , difficulty 1 = 3/7 , difficulty 2 = 3/5 , difficulty 3 = 4/7 , "),
            new Statistics("total = 17/19 , difficulty 1 = 6/7 , difficulty 2 = 5/5 , difficulty 3 = 6/7 , "),
            new Statistics("total = 15/19 , difficulty 1 = 5/7 , difficulty 2 = 4/5 , difficulty 3 = 6/7 , "),
            new Statistics("total = 15/19 , difficulty 1 = 5/7 , difficulty 2 = 5/5 , difficulty 3 = 5/7 , "),
            new Statistics("total = 13/19 , difficulty 1 = 4/7 , difficulty 2 = 2/5 , difficulty 3 = 7/7 , "),
            new Statistics("total = 9/19 , difficulty 1 = 7/7 , difficulty 2 = 1/5 , difficulty 3 = 1/7 , "),
            new Statistics("total = 11/19 , difficulty 1 = 6/7 , difficulty 2 = 0/5 , difficulty 3 = 5/7 , "),
            new Statistics("total = 12/19 , difficulty 1 = 4/7 , difficulty 2 = 4/5 , difficulty 3 = 4/7 , "),
            new Statistics("total = 9/19 , difficulty 1 = 4/7 , difficulty 2 = 5/5 , difficulty 3 = 0/7 , "),
            new Statistics("total = 13/19 , difficulty 1 = 7/7 , difficulty 2 = 5/5 , difficulty 3 = 1/7 , "),
            new Statistics("total = 10/19 , difficulty 1 = 3/7 , difficulty 2 = 3/5 , difficulty 3 = 4/7 , "),
            new Statistics("total = 14/19 , difficulty 1 = 6/7 , difficulty 2 = 4/5 , difficulty 3 = 4/7 , "),
            new Statistics("total = 8/19 , difficulty 1 = 5/7 , difficulty 2 = 3/5 , difficulty 3 = 0/7 , "),
            new Statistics("total = 15/19 , difficulty 1 = 6/7 , difficulty 2 = 4/5 , difficulty 3 = 5/7 , "),
            new Statistics("total = 16/19 , difficulty 1 = 5/7 , difficulty 2 = 4/5 , difficulty 3 = 7/7 , "),
            new Statistics("total = 12/19 , difficulty 1 = 7/7 , difficulty 2 = 4/5 , difficulty 3 = 1/7 , "),
            new Statistics("total = 11/19 , difficulty 1 = 5/7 , difficulty 2 = 0/5 , difficulty 3 = 6/7 , "),
            new Statistics("total = 12/19 , difficulty 1 = 3/7 , difficulty 2 = 4/5 , difficulty 3 = 5/7 , "),
            new Statistics("total = 11/19 , difficulty 1 = 6/7 , difficulty 2 = 5/5 , difficulty 3 = 0/7 , "),
        };
    }

    public static ReadOnlyHistory getSampleHistory() {
        History sampleHistory = new History();
        for (Statistics sampleStatistics : getSampleStatistics()) {
            sampleHistory.addStatistics(sampleStatistics);
        }

        return sampleHistory;
    }
}
