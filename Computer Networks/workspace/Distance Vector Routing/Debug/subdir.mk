################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../node0.c \
../node1.c \
../node2.c \
../node3.c \
../prog3.c 

OBJS += \
./node0.o \
./node1.o \
./node2.o \
./node3.o \
./prog3.o 

C_DEPS += \
./node0.d \
./node1.d \
./node2.d \
./node3.d \
./prog3.d 


# Each subdirectory must supply rules for building sources it contributes
node0.o: /home/kempa/Academic/Computer\ Networks/Computer\ Networking,\ A\ Top\ Down\ Approach\ Featuring\ The\ Internet\ -\ \ Preliminary\ Edition\ -\ Kurose,\ Ross/Exercises/Distance\ Vector\ Routing/node0.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"node0.d" -MT"node0.d" -o"$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

node1.o: /home/kempa/Academic/Computer\ Networks/Computer\ Networking,\ A\ Top\ Down\ Approach\ Featuring\ The\ Internet\ -\ \ Preliminary\ Edition\ -\ Kurose,\ Ross/Exercises/Distance\ Vector\ Routing/node1.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"node1.d" -MT"node1.d" -o"$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

node2.o: /home/kempa/Academic/Computer\ Networks/Computer\ Networking,\ A\ Top\ Down\ Approach\ Featuring\ The\ Internet\ -\ \ Preliminary\ Edition\ -\ Kurose,\ Ross/Exercises/Distance\ Vector\ Routing/node2.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"node2.d" -MT"node2.d" -o"$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

node3.o: /home/kempa/Academic/Computer\ Networks/Computer\ Networking,\ A\ Top\ Down\ Approach\ Featuring\ The\ Internet\ -\ \ Preliminary\ Edition\ -\ Kurose,\ Ross/Exercises/Distance\ Vector\ Routing/node3.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"node3.d" -MT"node3.d" -o"$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

%.o: ../%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o"$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


