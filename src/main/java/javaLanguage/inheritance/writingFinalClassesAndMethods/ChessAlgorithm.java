package javaLanguage.inheritance.writingFinalClassesAndMethods;

public class ChessAlgorithm {
    enum ChessPlayer { WHITE, BLACK }
    final ChessPlayer getFirstPlayer() {
        return ChessPlayer.WHITE;
    }
}

final class DcardAlgorithm extends ChessAlgorithm{
    // nothing to override
}

// DcardAlgorithm can not be extend
//class Eclass extends DcardAlgorithm {
//
//}
