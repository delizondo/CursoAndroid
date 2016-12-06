require 'calabash-android/calabash_steps'

Given(/^the app has launched$/) do
  wait_for do
    !query("*").empty?
  end
end

Then /^I search for the movie "([^\"]*)"$/ do |text|
  touch("* id:'search'")
  clear_text_in("* id:'search'")
  wait_for_keyboard
  keyboard_enter_text text
  hide_soft_keyboard()
  sleep(1)
end
