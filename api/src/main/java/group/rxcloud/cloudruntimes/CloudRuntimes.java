package group.rxcloud.cloudruntimes;

import group.rxcloud.cloudruntimes.domain.*;

/**
 * Cloud Runtimes standard API defined.
 */
public interface CloudRuntimes extends
        InvocationRuntimes,
        PubSubRuntimes,
        BindingRuntimes,
        StateRuntimes,
        SecretsRuntimes {
}
