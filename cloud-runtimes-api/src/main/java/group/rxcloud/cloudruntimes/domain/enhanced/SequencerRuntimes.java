package group.rxcloud.cloudruntimes.domain.enhanced;

import group.rxcloud.cloudruntimes.domain.enhanced.sequencer.GetNextIdRequest;
import group.rxcloud.cloudruntimes.domain.enhanced.sequencer.GetNextIdResponse;
import reactor.core.publisher.Mono;

/**
 * Sequencer API defined.
 */
public interface SequencerRuntimes {

    /**
     * Get next unique id with some auto-increment guarantee
     */
    Mono<GetNextIdResponse> getNextId(GetNextIdRequest request);
}
