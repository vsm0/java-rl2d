.PHONY: all build run clean

all: build run clean

build:
	gradle build --parallel

run:
	gradle run --parallel

clean:
	gradle clean --parallel

zip:
	gradle distZip --warning-mode all --parallel
