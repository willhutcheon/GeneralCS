#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define MAX_INPUT 1024
#define MAX_ARGS 128

void prompt(const char *shell_name) {
	if (shell_name[0] != '-') {
		printf("%s", shell_name);
		fflush(stdout);
	}
}
void execute_command(char *input, int background) {
	char *args[MAX_ARGS];
	int i = 0;
	char *token = strtok(input, " \t\n");
	while (token != NULL && i < MAX_ARGS - 1) {
		args[i++] = token;
		token = strtok(NULL, " \t\n");
	}
	args[i] = NULL;
	if (args[0] == NULL) return;
	if (strcmp(args[0], "exit") == 0) {
		exit(0);
	}
	pid_t pid = fork();
	if (pid < 0) {
		perror("fork");
	} else if (pid == 0) {
		if (execvp(args[0], args) == -1) {
			perror(args[0]);
		}
		_exit(EXIT_FAILURE);
	} else {
		if (!background) {
			wait(NULL);
		}
	}
}
int main(int argc, char *argv[]) {
	char input[MAX_INPUT];
	char *shell_name = (argc > 1) ? argv[1] : "whshell$: ";
	while (1) {
		prompt(shell_name);
		if (fgets(input, MAX_INPUT, stdin) == NULL) {
			break;
		}
		size_t len = strlen(input);
		if (len > 0 && input[len - 1] == '\n') {
			input[len - 1] = '\0';
		}
		int background = 0;
		if (len > 1 && input[len - 2] == '&') {
			background = 1;
			input[len - 2] = '\0';
		}
		if (strlen(input) == 0) {
			continue;
		}
		execute_command(input, background);
	}
	printf("\nExiting Shell...\n");
	return 0;
}
