package arhangel.dim.core.messages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by eaglesh on 29.04.16.
 */
@Repository
public class CommandRepository {
    private Map<Type, Command> commands = new HashMap<>();
    private Logger logger = LoggerFactory.getLogger(getClass());

    public CommandRepository() {}

    public Command getCommand(Type type) {
        return commands.get(type);
    }

    @PostConstruct
    public void initialize() {
        commands = Collections.unmodifiableMap(commands);
        logger.info("Инициализация завершена");
    }

    @Autowired
    public void addCommands(List<Command> commandList) {
        logger.info("В репозиторий добавлено "+ commandList.size() + " комманд");
        commands.putAll(commandList.stream().collect(Collectors.toMap(Command::getSupportedType, command -> command)));
    }
}
