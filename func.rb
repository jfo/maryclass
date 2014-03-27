# RUBY
system("clear")

@a = 0

def increment1
  @a += 1
end

# p @a
# increment1
# p @a
#

b = 0
def increment2(a)
  a + 1
end

# p b
# p increment2(b)
# p b
#

names = ["Mary", "Isla", "Sam"]
# p names.map {|e|  e.length}

[0,1,2,3,4].map {|e| e*e}

code_names = ['Mr. Pink', 'Mr. Orange', 'Mr. Blonde']

for i in (0...names.size) do
  # names[i] = code_names.sample
end
names

names.map {|e| code_names.sample}

for i in (0...names.size) do
  # names[i] = i.hash
end

names.map {|e| e = code_names.hash}

nums = [0,1,2,3,4]

nums.reduce{ |x, y| x + y }

def sum x, y
  x + y
end

nums.reduce(:+)

people = [{'name'=> 'Mary', 'height'=> 160},
          {'name'=> 'Isla', 'height'=> 80},
          {'name'=> 'Sam'}]

def nofuncheight(people)

  height_total = 0
  height_count = 0

  for person in people do
    if person['height']
      height_total += person['height']
      height_count += 1
    end
  end

  if height_count > 0
    average_height = height_total / height_count
    # puts average_height
  end
end

nofuncheight(people)


def avgheights(people)
  people.select! {|e| e["height"]}
  heights = people.map {|e| e["height"]}
  heights.reduce(:+) / heights.length
end

# p avgheights(people)





# cars!!!

def race(time = 5)

  car_positions = [1,1,1]

  while time > 1 do
    time -= 1
    puts ''
    for i in (0...car_positions.length) do
      if rand > 0.3
        car_positions[i] += 1
      end
      puts '-' * car_positions[i]
    end
  end
end

# race

# functionally but subroutines:

@time = 5
@car_positions = [1, 1, 1]

def move_cars
  @car_positions.map! {|n| rand > 0.3 ? n += 1 : n }
end

def draw_car(car_position)
  print '-' * car_position
  puts
end

def run_step_of_race
  @time -= 1
  move_cars
end

def draw
  puts
  for car_position in @car_positions
    draw_car(car_position)
  end
end

# while @time > 0
#   run_step_of_race
#   draw
# end


# functional version

def move_cars(car_positions)
  car_positions.map do |x|
    if rand > 0.3
      x + 1
    else
      x
    end
  end
end

def output_car(car_position)
  '-' * car_position
end

def run_step_of_race(state)
  {'time' => (state['time'] - 1),
   'car_positions' => move_cars(state['car_positions'])}
end

def draw(state)
  puts
  state['car_positions'].map do |e|
    output_car(e)
  end.join("\n")
end

def race(state)
  print draw(state)
  puts
  if state['time'] > 0
    race(run_step_of_race(state))
  end
end

race({'time'=> 5, 'car_positions'=> [1, 1, 1]})
