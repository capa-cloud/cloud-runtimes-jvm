package group.rxcloud.cloudruntimes;

import group.rxcloud.cloudruntimes.domain.*;

public interface CoreRuntimes extends
        InvocationRuntimes,
        PubSubRuntimes,
        BindingRuntimes,
        StateRuntimes,
        SecretsRuntimes {
}
