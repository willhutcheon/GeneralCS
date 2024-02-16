#pragma once
#include <random>
#include <vector>
#include "Card.h"
#include <stack>

class Deck
{
private:
	std::vector<std::unique_ptr<Card>> trueHome;
	std::default_random_engine& gen;
	std::stack<Card*> drawPile;
public:
	Deck(std::default_random_engine& gen);
	void reshuffle();
	Card* draw();
};