package org.pz.filededupe.outputinterfaces;

import org.pz.filededupe.LongStringListTable;

import java.util.List;
import java.util.function.Consumer;

/**
 * Prints duplicates and count to standard output
 *
 * @author dsaraiva
 */
class StandardOutputImpl extends DupesOutput implements StandardOutput {

    @Override
    public void output(LongStringListTable dupes) {
        super.output(dupes, getDupesConsumer(), getFinalCountConsumer());
    }

    private Consumer<List<String>> getDupesConsumer() {
        return paths -> {
            paths.sort(null);
            System.out.println( THESE_FILES_ARE_THE_SAME );
            for( String filepath : paths) {
                System.out.println( "\t" + filepath );
            }
            System.out.println();
        };
    }

    private Consumer<Integer> getFinalCountConsumer() {
        return dupesCount -> System.out.println( NUMBER_OF_DUPLICATES_FOUND + dupesCount );
    }
}