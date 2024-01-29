import matplotlib.pyplot as plt


def parse_trace_file(filename, selected_range):
    address_counts = {}  # Dictionary to store address counts
    freq = {
        "read_count": 0,
        "write_count": 0,
        "fetch": 0
    }

    with open(filename, 'r') as file:
        for line in file:
            operation, address_hex = line.strip().split()
            address = int(address_hex, 16)  # Convert hexadecimal address to decimal
            # Check if the address is within the selected range
            if selected_range[0] <= address <= selected_range[1]:
                if address in address_counts:
                    address_counts[address] += 1
                else:
                    address_counts[address] = 1

                if operation == '0':  # Read operation
                    freq["read_count"] += 1
                elif operation == '1':  # Write operation
                    freq["write_count"] += 1
                elif operation == '2':
                    freq["fetch"] += 1

    return address_counts, freq


def plot_histogram(address_counts, frequency, title):
    addresses = list(address_counts.keys())
    counts = list(address_counts.values())
    plt.figure(figsize=(10, 6))
    plt.bar(addresses, counts, width=.5, color='red')
    plt.title(title)
    plt.xlabel('Address (Decimal)')
    plt.ylabel('Frequency of Address')
    # Add annotations for read and write frequencies
    plt.annotate(f'Reads: {frequency["read_count"]}', xy=(0.05, 0.9), xycoords='axes fraction', fontsize=12)
    plt.annotate(f'Writes: {frequency["write_count"]}', xy=(0.05, 0.85), xycoords='axes fraction', fontsize=12)
    plt.annotate(f'Fetch: {frequency["fetch"]}', xy=(0.05, 0.8), xycoords='axes fraction', fontsize=12)
    plt.grid(True)
    plt.show()

#Defining the address range
#selected_range = (4394000, 4397000) #range for the cc1.din
selected_range =   (268519190, 268519590) #Range for the spice.din 


# Parse and plot histograms for cc1.din
#cc1_address_counts, freq = parse_trace_file('/Users/ganapathisubramaniam/Downloads/CS402/HW/HW1/tex.din', selected_range)
#plot_histogram(dict(cc1_address_counts), freq, 'Histogram for CC1.din')

# Parse and plot histograms for spice.din
spice_address_counts, freq = parse_trace_file('/Users/ganapathisubramaniam/Downloads/CS402/HW/HW1/spice.din', selected_range)
plot_histogram(spice_address_counts,freq, 'Histogram for spice.din')